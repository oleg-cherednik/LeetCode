import java.util.Arrays;
import java.util.TreeMap;

/**
 * You are given an array of <tt>intervals</tt>, where <tt>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</tt> and each
 * <tt>start<sub>i</sub></tt> is <b>unique</b>.
 * <p>
 * The <b>right interval</b> for an interval <tt>i</tt> is an interval <tt>j</tt> such that <tt>start<sub>j</sub> >= end<sub>i</sub></tt> and
 * <tt>start<sub>j</sub></tt> is minimized.
 * <p>
 * Return <i>an array of <b>right interval</b> indices for each interval <tt>i</tt></i>. If no <b>right interval</b> exists for interval <tt>i</tt>,
 * then put <tt>-1</tt> at index <tt>i</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= intervals.length <= 2 * 10<sup>4</sup></tt></li>
 * <li><tt>intervals[i].length == 2</tt></li>
 * <li><tt>-10<sup>6</sup> <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>6</sup></tt></li>
 * <li>The start point of each interval is <b>unique</b>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 2 } })));                      // [-1]
        System.out.println(Arrays.toString(findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } })));  // [-1,0,1]
        System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } })));  // [-1,2,-1]
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i][0], i);

        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1 : map.get(key);
        }

        return res;
    }

}
