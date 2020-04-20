/**
 * Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.
 * <p>
 * Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when they have both left and right forks. Each fork
 * can be held by only one philosopher and so a philosopher can use the fork only if it is not being used by another philosopher. After an individual
 * philosopher finishes eating, they need to put down both forks so that the forks become available to others. A philosopher can take the fork on
 * their right or the one on their left as they become available, but cannot start eating before getting both forks.
 * <p>
 * Eating is not limited by the remaining amounts of spaghetti or stomach space; an infinite supply and an infinite demand are assumed.
 * <p>
 * Design a discipline of behaviour (a concurrent algorithm) such that no philosopher will starve; i.e., each can forever continue to alternate
 * between eating and thinking, assuming that no philosopher can know when others may want to eat or think.
 * <p>
 * <img src="an_illustration_of_the_dining_philosophers_problem.png" />
 * <p>
 * <i>The problem statement and the image above are taken from <a href="https://en.wikipedia.org/wiki/Dining_philosophers_problem">wikipedia.org</a></i>
 * <ul>
 * The philosophers' ids are numbered from <b>0</b> to <b>4</b> in a <b>clockwise</b> order. Implement the function <tt>void wantsToEat(philosopher, pickLeftFork,
 * pickRightFork, eat, putLeftFork, putRightFork)</tt> where:
 * <li><tt>philosopher</tt> is the id of the philosopher who wants to eat.</li>
 * <li><tt>pickLeftFork</tt> and <tt>pickRightFork</tt> are functions you can call to pick the corresponding forks of that philosopher.</li>
 * <li><tt>eat</tt> is a function you can call to let the philosopher eat once he has picked both forks.</li>
 * <li><tt>putLeftFork</tt> and <tt>putRightFork</tt> are functions you can call to put down the corresponding forks of that philosopher.</li>
 * <li>The philosophers are assumed to be thinking as long as they are not asking to eat (the function is not being called with their number).</li>
 * </ul>
 * Five threads, each representing a philosopher, will simultaneously use one object of your class to simulate the process. The function may be
 * called for the same philosopher more than once, even before the last call ends.
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 1
 * Output: [[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],[3,1,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]
 * Explanation:
 * n is the number of times each philosopher will call the function.
 * The output array describes the calls you made to the functions controlling the forks and the eat function, its format is:
 * output[i] = [a, b, c] (three integers)
 * - a is the id of a philosopher.
 * - b specifies the fork: {1 : left, 2 : right}.
 * - c specifies the operation: {1 : pick, 2 : put, 3 : eat}.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 60</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.04.2020
 */
public class Solution {

    public static void main(String... args) throws InterruptedException {
        execute(1);
        execute(2);
    }

    private static void execute(int n) throws InterruptedException {
        DiningPhilosophers table = new DiningPhilosophers();
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < philosophers.length; i++)
            philosophers[i] = new Philosopher(i, n, table);

        for (int i = 0; i < philosophers.length; i++)
            philosophers[i].start();

        for (int i = 0; i < philosophers.length; i++)
            philosophers[i].join();

        System.out.println();
    }

}

class Philosopher extends Thread {

    private final int id;
    private final int n;
    private final DiningPhilosophers table;

    private boolean leftFork;
    private boolean rightFork;

    public Philosopher(int id, int n, DiningPhilosophers table) {
        super(String.valueOf(id));
        this.table = table;
        this.id = id;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            Runnable pickLeftFork = () -> leftFork = true;
            Runnable pickRightFork = () -> rightFork = true;
            Runnable eat = () -> System.out.format("#%d - [%s:%s]\n", id, leftFork, rightFork);
            Runnable putLeftFork = () -> leftFork = false;
            Runnable putRightFork = () -> rightFork = false;

            for (int i = 0; i < n; i++)
                table.wantsToEat(id, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DiningPhilosophers {

    private int count;

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        while (true) {
            if (count == philosopher) {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();

                count = count == 4 ? 0 : count + 1;
                notifyAll();
                break;
            } else
                wait();
        }
    }
}
