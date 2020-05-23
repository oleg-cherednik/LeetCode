import java.util.LinkedList;
import java.util.List;

/**
 * Given two lists of <b>closed</b> intervals, each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * <i>(Formally, a closed interval <tt>[a, b]</tt> (with <tt>a <= b</tt>) denotes the set of real numbers <tt>x</tt> with <tt>a <= x <= b</tt>.  The
 * intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval. For example, the
 * intersection of <tt>[1, 3]</tt> and <tt>[2, 4]</tt> is <tt>[2, 3]</tt>.)</i>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="interval1.png" />
 * <pre>
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>0 <= A.length < 1000</tt></li>
 * <li><tt>0 <= B.length < 1000</tt></li>
 * <li><tt>0 <= A[i].start</tt>, <tt>A[i].end</tt>, <tt>B[i].start</tt>, <tt>B[i].end < 10<sup>9</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 23.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(intervalIntersectionString(
                new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
                new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } }));  // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(intervalIntersectionString(new int[][] { { 1, 2 } }, new int[][] { { 3, 4 } }));  // []
    }

    private static String intervalIntersectionString(int[][] A, int[][] B) {
        int[][] res = intervalIntersection(A, B);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int[] r : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append('[').append(r[START]).append(',').append(r[END]).append(']');
        }

        buf.append(']');

        return buf.toString();
    }

    private static final int START = 0;
    private static final int END = 1;

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new LinkedList<>();

        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[START] < b[START]) {
                if (a[END] < b[START])
                    i++;
                else if (a[END] <= b[END]) {
                    res.add(new int[] { b[START], a[END] });
                    i++;
                } else {
                    res.add(new int[] { b[START], b[END] });
                    j++;
                }
            } else if (a[START] <= b[END]) {
                if (a[END] <= b[END]) {
                    res.add(new int[] { a[START], a[END] });
                    i++;
                } else {
                    res.add(new int[] { a[START], b[END] });
                    j++;
                }
            } else
                j++;
        }

        int i = 0;
        int[][] arr = new int[res.size()][];

        for (int[] r : res)
            arr[i++] = r;

        return arr;
    }

}
