import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a set of <i>non-overlapping</i> intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 13.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(insertStr(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }))); // [[1, 5], [6, 9]]
        System.out.println(Arrays.toString(insertStr(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 })));
//         [[1, 2], [3, 10], [12, 16]]
        System.out.println(Arrays.toString(insertStr(new int[][] { { 1, 5 } }, new int[] { 2, 3 })));   // [[1, 5]]
        System.out.println(Arrays.toString(insertStr(new int[][] { { 1, 5 } }, new int[] { 6, 8 })));   // [[1, 5], [6, 8]]
    }

    private static String[] insertStr(int[][] intervals, int[] newInterval) {
        int[][] res = insert(intervals, newInterval);
        String[] arr = new String[res.length];

        for (int i = 0; i < res.length; i++)
            arr[i] = Arrays.toString(res[i]);

        return arr;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Deque<int[]> arr = new ArrayDeque<>();

        for (int i = 0; i < intervals.length; ) {
            if (newInterval == null) {
                if (arr.isEmpty())
                    arr.addLast(intervals[i++]);
                else if (arr.getLast()[1] < intervals[i][0])
                    arr.addLast(intervals[i++]);
                else
                    arr.getLast()[1] = Math.max(arr.getLast()[1], intervals[i++][1]);
            } else {
                if (arr.isEmpty() || arr.getLast()[1] < newInterval[0]) {
                    if (intervals[i][0] < newInterval[0])
                        arr.addLast(intervals[i++]);
                    else {
                        arr.addLast(newInterval);
                        newInterval = null;
                    }
                } else {
                    arr.getLast()[1] = Math.max(arr.getLast()[1], newInterval[1]);
                    newInterval = null;
                }
            }
        }

        if (newInterval != null) {
            if (arr.isEmpty())
                arr.addLast(newInterval);
            else if (arr.getLast()[1] < newInterval[0])
                arr.addLast(newInterval);
            else
                arr.getLast()[1] = Math.max(arr.getLast()[1], newInterval[1]);
        }

        int[][] res = new int[arr.size()][];

        for (int i = 0; i < res.length; i++)
            res[i] = arr.remove();

        return res;
    }

}
