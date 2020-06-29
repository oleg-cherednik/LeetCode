import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a <tt>m x n</tt> grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked
 * <tt>'Finish'</tt> in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <img src="robot_maze.png" />
 * <p>
 * Above is a <tt>7 x 3</tt> grid. How many possible unique paths are there?
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: m = 7, n = 3
 * Output: 28
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= m</tt>, <tt>n <= 100</tt></li>
 * <li>It's guaranteed that the answer will be less than or equal to <tt>2 * 10<sup>9</sup></tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 29.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(uniquePaths(3, 2));   // 3
        System.out.println(uniquePaths(7, 3));   // 28
    }

    public static int uniquePaths(int m, int n) {
        int[] line = new int[m];
        Arrays.fill(line, 1);

        for (int row = 1; row < n; row++)
            for (int col = 1; col < m; col++)
                line[col] += line[col - 1];

        return line[m - 1];
    }

}
