import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Suppose you are given the following code:
 * <pre>
 * class ZeroEvenOdd {
 *     public ZeroEvenOdd(int n) { ... }      // constructor
 *     public void zero(printNumber) { ... }  // only output 0's
 *     public void even(printNumber) { ... }  // only output even numbers
 *     public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * </pre>
 * <ol>
 * The same instance of <tt>ZeroEvenOdd</tt> will be passed to three different threads:
 * <p>
 * <li>Thread <tt>A</tt> will call <tt>zero()</tt> which should only output 0's.</li>
 * <li>Thread <tt>B</tt> will call <tt>even()</tt> which should only ouput even numbers.</li>
 * <li>Thread <tt>C</tt> will call <tt>odd()</tt> which should only output odd numbers.</li>
 * </ol>
 * Each of the threads is given a <tt>printNumber</tt> method to output an integer. Modify the given program to output the series <tt>010203040506...</tt>
 * where the length of the series must be <tt>2n</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd().
 * "0102" is the correct output.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 5
 * Output: "0102030405"
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute(2);   // 0102
        execute(5);   // 0102030405
    }

    private static void execute(int n) throws InterruptedException {
        ZeroEvenOdd obj = new ZeroEvenOdd(n);

        Thread zero = new Thread(() -> {
            try {
                obj.zero(System.out::print);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread even = new Thread(() -> {
            try {
                obj.even(System.out::print);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odd = new Thread(() -> {
            try {
                obj.odd(System.out::print);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        zero.start();
        even.start();
        odd.start();

        zero.join();
        even.join();
        odd.join();

        System.out.println();
    }

}

class ZeroEvenOdd {

    private final Semaphore zero = new Semaphore(1);
    private final Semaphore even = new Semaphore(0);
    private final Semaphore odd = new Semaphore(0);

    private int n;
    private int i = 1;

    public ZeroEvenOdd(int n) {
        this.n = n * 2;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            zero.acquire();

            if (n == 0)
                break;

            printNumber.accept(0);
            n--;
            (i % 2 == 0 ? even : odd).release();
        }

        even.release();
        odd.release();

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            even.acquire();

            if (n == 0)
                break;

            printNumber.accept(i++);
            n--;
            zero.release();
        }

        zero.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            odd.acquire();

            if (n == 0)
                break;

            printNumber.accept(i++);
            n--;
            zero.release();
        }

        zero.release();
    }
}
