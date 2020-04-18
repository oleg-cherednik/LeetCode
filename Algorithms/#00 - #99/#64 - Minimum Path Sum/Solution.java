/**
 * Given a <tt>m x n</tt> grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the <tt>sum</tt> of all
 * numbers along its path.
 * <p>
 * <b>Note:</b> You can only move either down or right at any point in time.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));   // 7
    }

    public static int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int left = col == 0 ? Integer.MAX_VALUE : grid[row][col - 1];
                int top = row == 0 ? Integer.MAX_VALUE : grid[row - 1][col];

                if (left != Integer.MAX_VALUE || top != Integer.MAX_VALUE)
                    grid[row][col] += Math.min(left, top);
            }
        }

        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
