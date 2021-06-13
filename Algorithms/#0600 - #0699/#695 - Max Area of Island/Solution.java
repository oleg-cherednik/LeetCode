/**
 * You are given an <tt>m x n</tt> binary matrix <tt>grid</tt>. An island is a group of <tt>1's</tt>
 * (representing land) connected <b>4-directionally</b> (horizontal or vertical.) You may assume all
 * four edges of the grid are surrounded by water.
 * <p>
 * The <b>area</b> of an island is the number of cells with a value <tt>1</tt> in the island.
 * <p>
 * Return <i>the maximum <b>area</b> of an island in <tt>grid</tt></i>. If there is no island, return <tt>0</tt>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="maxarea1-grid.jpg" />
 * <pre>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *                [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *                [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *                [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *                [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *                [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *                [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *                [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>m == grid.length</tt></li>
 * <li><tt>n == grid[i].length</tt>.</li>
 * <li><tt>1 <= m</tt>, <tt>n <= 50</tt></li>
 * <li><tt>grid[i][j]</tt> is either <tt>0</tt> or <tt>1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.06.2021
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxAreaOfIsland(new int[][] {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));  // 6
        System.out.println(maxAreaOfIsland(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0 } }));  // 0
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int num = -1;
        int size = 0;

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (grid[row][col] == 1)
                    size = Math.max(size, dfs(grid, row, col, 0, num--));

        return size;
    }

    private static int dfs(int[][] grid, int row, int col, int size, int num) {
        while (true) {
            if (row < 0 || row >= grid.length)
                return size;
            if (col < 0 || col >= grid[row].length)
                return size;
            if (grid[row][col] != 1)
                return size;

            grid[row][col] = num;
            size++;

            size = dfs(grid, row, col - 1, size, num);
            size = dfs(grid, row, col + 1, size, num);
            size = dfs(grid, row - 1, col, size, num);
            row++;
        }
    }

}
