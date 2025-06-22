import java.util.Arrays;

/**
 * A school is trying to take an annual photo of all the students. The students
 * are asked to stand in a single file line in <b>non-decreasing order</b> by
 * height. Let this ordering be represented by the integer array <tt>expected</tt>
 * where <tt>expected[i]</tt> is the expected height of the <tt>i<sup>th</sup></tt>
 * student in line.
 * <p>
 * You are given an integer array <tt>heights</tt> representing the <b>current order</b>
 * that the students are standing in. Each <tt>heights[i]</tt> is the height of
 * the <tt>i<sup>th</sup></tt> student in line (<b>0-indexed</b>).
 * <p>
 * Return <i><b>the number of indices</b> where</i> <tt>heights[i] != expected[i]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 * <pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= heights.length <= 100</tt></li>
 * <li><tt>1 <= heights[i] <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.06.2025
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));  // 3
        System.out.println(heightChecker(new int[] { 5, 1, 2, 3, 4 }));     // 5
        System.out.println(heightChecker(new int[] { 1, 2, 3, 4, 5 }));     // 0
    }

    public static int heightChecker(int[] heights) {
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);

        int res = 0;

        for (int i = 0; i < heights.length; i++)
            if (heights[i] != arr[i])
                res++;

        return res;
    }
}
