/**
 * Given a <tt>m * n</tt> matrix of ones and zeros, return how many <b>square</b> submatrices have all ones.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 300</tt></li>
 * <li><tt>1 <= arr[0].length <= 300</tt></li>
 * <li><tt>0 <= arr[i][j] <= 1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 21.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));                       // 15
        System.out.println(countSquares(new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }));                                // 7
        System.out.println(countSquares(new int[][] { { 1 } }));                                                                // 1
        System.out.println(countSquares(new int[][] { { 0 } }));                                                                // 0
        System.out.println(countSquares(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 0 } }));      // 8
        System.out.println(countSquares(new int[][] {
                { 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1 } }));  // 19
    }

    public static int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

                res += dp[i][j];
            }
        }

        return res;
    }

}
