/**
 * <ul>
 * In a given grid, each cell can have one of three values:
 * <li>the value <tt>0</tt> representing an empty cell;</li>
 * <li>the value <tt>1</tt> representing a fresh orange;</li>
 * <li>the value <tt>2</tt> representing a rotten orange.</li>
 * </ul>
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
 * return <tt>-1</tt> instead.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="oranges.png" />
 * <pre>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens
 * 4-directionally.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= grid.length <= 10</tt></li>
 * <li><tt>1 <= grid[0].length <= 10</tt></li>
 * <li><tt>grid[i][j]</tt> is only <tt>0</tt>, <tt>1</tt>, or <tt>2</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 09.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(orangesRotting(new int[][] {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 } }));    // 4
        System.out.println(orangesRotting(new int[][] {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 } }));    // -1
        System.out.println(orangesRotting(new int[][] { { 0, 2 } }));   // 0
    }

    public static int orangesRotting(int[][] grid) {
        int minute = 0;
        boolean proceed = true;

        while (proceed) {
            proceed = false;

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] != 2)
                        continue;

                    grid[row][col] = 22;
                    proceed |= replace(grid, row, col - 1, 1, -2);
                    proceed |= replace(grid, row, col + 1, 1, -2);
                    proceed |= replace(grid, row - 1, col, 1, -2);
                    proceed |= replace(grid, row + 1, col, 1, -2);
                }
            }

            if (proceed) {
                minute++;
                replace(grid, -2, 2);
            }
        }

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (grid[row][col] == 1)
                    return -1;

        return minute;
    }

    private static boolean replace(int[][] grid, int row, int col, int oldVal, int newVal) {
        if (row < 0 || row >= grid.length)
            return false;
        if (col < 0 || col >= grid[row].length)
            return false;
        if (grid[row][col] != oldVal)
            return false;

        grid[row][col] = newVal;
        return true;
    }

    private static void replace(int[][] grid, int oldVal, int newVal) {
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (grid[row][col] == oldVal)
                    grid[row][col] = newVal;
    }

}
