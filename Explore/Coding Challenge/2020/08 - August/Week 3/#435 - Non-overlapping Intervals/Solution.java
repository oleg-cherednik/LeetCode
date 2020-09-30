import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>You may assume the interval's end point is always bigger than its start point.</li>
 * <li>Intervals like <tt>[1,2]</tt> and <tt>[2,3]</tt> have borders "touching" but they don't overlap each other.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 15.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));          // 1
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));                    // 2
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } }));                              // 0
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } }));    // 2
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int[] prv = null;

        for (int[] interval : intervals) {
            if (prv == null)
                prv = interval;
            else if (prv[1] > interval[0]) {
                if (interval[1] < prv[1])
                    prv = interval;

                count++;
            } else
                prv = interval;
        }

        return count;
    }

}
