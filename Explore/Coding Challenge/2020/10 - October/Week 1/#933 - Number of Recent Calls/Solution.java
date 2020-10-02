import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You have a <tt>RecentCounter</tt> class which counts the number of recent requests within a certain time frame.
 * <p>
 * <ul>
 * Implement the RecentCounter class:
 * <li><tt>RecentCounter()</tt> Initializes the counter with zero recent requests.</li>
 * <li><tt>int ping(int t)</tt> Adds a new request at time <tt>t</tt>, where <tt>t</tt> represents some time in milliseconds, and returns the number
 * of requests that has happened in the past <tt>3000</tt> milliseconds (including the new request). Specifically, return the number of requests that
 * have happened in the inclusive range <tt>[t - 3000, t]</tt>.</li>
 * </ul>
 * It is <b>guaranteed</b> that every call to ping uses a strictly larger value of t than the previous call.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 *
 * Output
 * [null, 1, 2, 3, 3]
 *
 * Explanation
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= t <= 10<sup>9</sup></tt></li>
 * <li>Each test case will call ping with <b>strictly increasing</b> values of <tt>t</tt>.</li>
 * <li>At most <tt>10<sup>4</sup></tt> calls will be made to ping.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(example(1, 100, 3001, 3002)));   // [1, 2, 3, 3]
    }

    private static int[] example(int... pings) {
        RecentCounter obj = new RecentCounter();
        return Arrays.stream(pings).map(obj::ping).toArray();
    }
}

class RecentCounter {

    private final Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        int lower = t - 3000;

        while (!queue.isEmpty() && queue.element() < lower) {
            queue.poll();
        }

        queue.add(t);
        return queue.size();
    }
}
