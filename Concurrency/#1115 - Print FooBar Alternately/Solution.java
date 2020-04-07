import java.util.concurrent.Semaphore;

/**
 * Suppose you are given the following code:
 * <pre>
 * class FooBar {
 *     public void foo() {
 *         for (int i = 0; i < n; i++) {
 *             print("foo");
 *         }
 *     }
 *
 *     public void bar() {
 *         for (int i = 0; i < n; i++) {
 *             print("bar");
 *         }
 *     }
 * }
 * </pre>
 * The same instance of <tt>FooBar</tt> will be passed to two different <tt>threads</tt>. Thread <tt>A</tt> will call <tt>foo()</tt> while thread
 * <tt></tt>B will call <tt>bar()</tt>. Modify the given program to output <tt>"foobar"</tt> <tt>n</tt> times.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1
 * time.
 * </pre>
 * <b>xExample 2:</b>
 * <pre>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 07.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute(1);   // foobar
        execute(2);   // foobarfoobar
    }

    private static void execute(int n) throws InterruptedException {
        FooBar obj = new FooBar(n);

        Thread foo = new Thread(() -> {
            try {
                obj.foo(() -> System.out.print("foo"));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread bar = new Thread(() -> {
            try {
                obj.bar(() -> System.out.print("bar"));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        foo.start();
        bar.start();

        foo.join();
        bar.join();

        System.out.println();
    }

}

class FooBar {

    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}
