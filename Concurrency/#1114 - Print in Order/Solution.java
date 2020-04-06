/**
 * Suppose we have a class:
 * <pre>
 * public class Foo {
 *     public void first() { print("first"); }
 *     public void second() { print("second"); }
 *     public void third() { print("third"); }
 * }
 * </pre>
 * The same instance of <tt>Foo</tt> will be passed to three different threads. Thread <tt>A</tt> will call <tt>first()</tt>, thread <tt>B</tt> will
 * call <tt>second()</tt>, and thread <tt>C</tt> will call <tt>third()</tt>. Design a mechanism and modify the program to ensure that
 * <tt>second()</tt> is executed after <tt>first()</tt>, and <tt>third()</tt> is executed after second().
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and
 * thread C calls third(). "firstsecondthird" is the correct output.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the
 * correct output.
 * </pre>
 * <b>Note:</b>
 * <p>
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The
 * input format you see is mainly to ensure our tests' comprehensiveness.
 *
 * @author Oleg Cherednik
 * @since 06.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute(1, 2, 3);   // firstsecondthird
        execute(1, 3, 2);   // firstsecondthird
    }

    private static void execute(int... ids) throws InterruptedException {
        Foo foo = new Foo();

        for (int id : ids) {
            if (id == 1) {
                new Thread(() -> {
                    try {
                        foo.first(() -> System.out.print("first"));
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (id == 2) {
                new Thread(() -> {
                    try {
                        foo.second(() -> System.out.print("second"));
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (id == 3) {
                new Thread(() -> {
                    try {
                        foo.third(() -> System.out.print("third"));
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }

        Thread.sleep(500);
        System.out.println();
    }

}

class Foo {

    private int order = 1;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (order != 1)
            wait();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        order++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (order != 2)
            wait();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        order++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (order != 3)
            wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        order++;
        notifyAll();
    }
}
