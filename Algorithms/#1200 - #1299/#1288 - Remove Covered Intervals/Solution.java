import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of <tt>intervals</tt>, remove all intervals that are covered by another interval in the list.
 * <p>
 * Interval <tt>[a,b)</tt> is covered by interval <tt>[c,d)</tt> if and only if <tt>c <= a</tt> and <tt>b <= d</tt>.
 * <p>
 * After doing so, return <i>the number of remaining intervals</i>s.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: intervals = [[0,10],[5,12]]
 * Output: 2
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: intervals = [[3,10],[4,10],[5,11]]
 * Output: 2
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: intervals = [[1,2],[1,4],[3,4]]
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= intervals.length <= 1000</tt></li>
 * <li><tt>intervals[i].length == 2</tt></li>
 * <li><tt>0 <= intervals[i][0] < intervals[i][1] <= 10<sup>5</sup></tt></li>
 * <li>All the intervals are <b>unique</b>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } }));       // 2
        System.out.println(removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } }));                 // 1
        System.out.println(removeCoveredIntervals(new int[][] { { 0, 10 }, { 5, 12 } }));               // 2
        System.out.println(removeCoveredIntervals(new int[][] { { 3, 10 }, { 4, 10 }, { 5, 11 } }));    // 2
        System.out.println(removeCoveredIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 3, 4 } }));       // 1
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>(intervals.length, (one, two) -> {
            int res = Integer.compare(one[0], two[0]);
            return res == 0 ? Integer.compare(two[1], one[1]) : res;
        });

        queue.addAll(Arrays.asList(intervals));

        Deque<int[]> stack = new ArrayDeque<>(intervals.length);

        while (!queue.isEmpty()) {
            int[] interval = queue.remove();

            if (stack.isEmpty())
                stack.push(interval);
            else {
                int[] prv = stack.element();

                if (prv[0] > interval[0] || prv[1] < interval[1])
                    stack.push(interval);
            }
        }

        return stack.size();
    }
}
