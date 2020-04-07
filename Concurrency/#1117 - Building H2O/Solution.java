import java.util.concurrent.Semaphore;

/**
 * There are two kinds of threads, <tt>oxygen</tt> and <tt>hydrogen</tt>. Your goal is to group these threads to form water molecules. There is a
 * barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given <tt>releaseHydrogen</tt>
 * and <tt>releaseOxygen</tt> methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of
 * three, and they must be able to immediately bond with each other to form a water molecule. You must guarantee that all the threads from one
 * molecule bond <i>before</i> any other threads from the next molecule do.
 * <p>
 * <ul>
 * In other words:
 * <p>
 * <li>If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen threads.</li>
 * <li>If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread and another hydrogen thread.</li>
 * </ul>
 * We don’t have to worry about matching the threads up explicitly; that is, the threads do not necessarily know which other threads they are paired
 * up with. The key is just that threads pass the barrier in complete sets; thus, if we examine the sequence of threads that bond and divide them
 * into groups of three, each group should contain one oxygen and two hydrogen threads.
 * <p>
 * Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "HOH"
 * Output: "HHO"
 * Explanation: "HOH" and "OHH" are also valid answers.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "OOHHHH"
 * Output: "HHOHHO"
 * Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
 * </pre>
 * <b>Constraints:</b>
 * <ul>
 * <li>Total length of input string will be <tt>3n</tt>, where <tt>1 ≤ n ≤ 20</tt>.</li>
 * <li>Total number of <tt>H</tt> will be <tt>2n</tt> in the input string.</li>
 * <li>Total number of <tt>O</tt> will be <tt>n</tt> in the input string.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute("HOH");     // HHO
        execute("OOHHHH");  // HHOHHO
    }

    private static void execute(String str) throws InterruptedException {
        H2O obj = new H2O();

        Thread hydrogen = new Thread(() -> {
            try {
                for (int i = 0; i < str.length(); i++)
                    if (str.charAt(i) == 'H')
                        obj.hydrogen(() -> System.out.print("H"));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread oxygen = new Thread(() -> {
            try {
                for (int i = 0; i < str.length(); i++)
                    if (str.charAt(i) == 'O')
                        obj.oxygen(() -> System.out.print("O"));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        hydrogen.start();
        oxygen.start();

        hydrogen.join();
        oxygen.join();

        System.out.println();
    }

}

class H2O {

    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        if (hydrogen.availablePermits() == 0)
            oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogen.release(2);
    }
}
