import java.util.function.IntConsumer;

/**
 * <ul>
 * Write a program that outputs the string representation of numbers from <tt>1</tt> to <tt>n</tt>, however:
 * <li>If the number is divisible by <tt>3</tt>, output <tt>"fizz"</tt>.</li>
 * <li>If the number is divisible by <tt>5</tt>, output <tt>"buzz"</tt>.</li>
 * <li>If the number is divisible by both <tt>3</tt> and <tt>5</tt>, output <tt>"fizzbuzz"</tt>.</li>
 * </ul>
 * For example, for <tt>n = 15</tt>, we output: <tt>1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz</tt>.
 * <p>
 * Suppose you are given the following code:
 * <pre>
 * class FizzBuzz {
 *     public FizzBuzz(int n) { ... }               // constructor
 *     public void fizz(printFizz) { ... }          // only output "fizz"
 *     public void buzz(printBuzz) { ... }          // only output "buzz"
 *     public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *     public void number(printNumber) { ... }      // only output the numbers
 * }
 * </pre>
 * <ol>
 * Implement a multithreaded version of <tt>FizzBuzz</tt> with <b>four</b> threads. The same instance of <tt>FizzBuzz</tt> will be passed to four
 * different threads:
 * <li>Thread <tt>A</tt> will call <tt>fizz()</tt> to check for divisibility of <tt>3</tt> and outputs <tt>fizz</tt>.</li>
 * <li>Thread <tt>B</tt> will call <tt>buzz()</tt> to check for divisibility of <tt>5</tt> and outputs <tt>buzz</tt>.</li>
 * <li>Thread <tt>C</tt> will call <tt>fizzbuzz()</tt> to check for divisibility of <tt>3</tt> and <tt>5</tt> and outputs <tt>fizzbuzz</tt>.</li>
 * <li>Thread <tt>D</tt> will call <tt>number()</tt> which should only output the numbers.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 07.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute(15);    // 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz
    }

    private static void execute(int n) throws InterruptedException {
        FizzBuzz obj = new FizzBuzz(n);

        Thread fizz = new Thread(() -> {
            try {
                obj.fizz(() -> System.out.print("fizz, "));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzz = new Thread(() -> {
            try {
                obj.buzz(() -> System.out.print("buzz, "));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzbuzz = new Thread(() -> {
            try {
                obj.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread number = new Thread(() -> {
            try {
                obj.number(value -> System.out.print(value + ", "));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();

        fizz.join();
        buzz.join();
        fizzbuzz.join();
        number.join();

        System.out.println();
    }

}

class FizzBuzz {

    private final Object lock = new Object();
    private final int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (i > n)
                    break;
                if (i % 3 != 0 || i % 5 == 0)
                    lock.wait();
                else {
                    printFizz.run();
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (i > n)
                    break;
                if (i % 3 == 0 || i % 5 != 0)
                    lock.wait();
                else {
                    printBuzz.run();
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (i > n)
                    break;
                if (i % 3 != 0 || i % 5 != 0)
                    lock.wait();
                else {
                    printFizzBuzz.run();
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (i > n)
                    break;
                if (i % 3 == 0 || i % 5 == 0)
                    lock.wait();
                else {
                    printNumber.accept(i);
                    i++;
                    lock.notifyAll();
                }
            }
        }
    }
}
