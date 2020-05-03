/**
 * You are given an <tt>m * n</tt> matrix, <tt>mat</tt>, and an integer <tt>k</tt>, which has its rows sorted in non-decreasing order.
 * <p>
 * You are allowed to choose exactly 1 element from each row to form an array. Return the Kth <b>smallest</b> array sum among all possible arrays.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * Output: 9
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: mat = [[1,1,10],[2,2,9]], k = 7
 * Output: 12
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>m == mat.length</tt></li>
 * <li><tt>n == mat.length[i]</tt></li>
 * <li><tt>1 <= m, n <= 40</tt></li>
 * <li><tt>1 <= k <= min(200, n ^ m)</tt></li>
 * <li><tt>1 <= mat[i][j] <= 5000</tt></li>
 * <li><tt>mat[i]</tt> is a non decreasing array.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kthSmallest(new int[][] {
                { 1, 10, 10 },
                { 1, 4, 5 },
                { 2, 3, 6 }
        }, 7)); // 9
    }

    public static int kthSmallest(int[][] mat, int k) {
        return -1;
    }
}
