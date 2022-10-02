/**
 * You are given an <tt>m x n</tt> integer array <tt>grid</tt>. There is a robot initially located at the <b>top-left
 * corner</b> (i.e., <tt>grid[0][0]</tt>). The robot tries to move to the <b>bottom-right corner</b> (i.e.,
 * <tt>grid[m-1][n-1]</tt>). The robot can only move either down or right at any point in time.
 * <p>
 * An obstacle and space are marked as <tt>1</tt> or <tt>0</tt> respectively in grid. A path that the robot takes cannot
 * include <b>any</b> square that is an obstacle.
 * <p>
 * Return <i>the number of possible unique paths that the robot can take to reach the bottom-right corner</i>.
 * <p>
 * The testcases are generated so that the answer will be less than or equal to <tt>2 * 10<sup>9</sup></tt>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="img.png" />
 * <pre>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="img2.png" />
 * <pre>
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>m == obstacleGrid.length</tt></li>
 * <li><tt>n == obstacleGrid[i].length</tt></li>
 * <li><tt>1 <= m</tt>, <tt>n <= 100</tt></li>
 * <li><tt>obstacleGrid[i][j]</tt> is <tt>0</tt> or <tt>1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));   // 2
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));   // 1
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0 } }));   // 1
        System.out.println(uniquePathsWithObstacles(new int[][] { { 1 } }));   // 0
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (obstacleGrid[row][col] == 0) {
                    if (row == 0 && col == 0)
                        obstacleGrid[0][0] = 1;
                    else {
                        int left = col > 0 ? obstacleGrid[row][col - 1] : 0;
                        int up = row > 0 ? obstacleGrid[row - 1][col] : 0;
                        obstacleGrid[row][col] = left + up;
                    }
                } else
                    obstacleGrid[row][col] = 0;
            }
        }

        return obstacleGrid[height - 1][width - 1];
    }

}
