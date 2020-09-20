/**
 * <ul>
 * On a 2-dimensional <tt>grid</tt>, there are 4 types of squares:
 * <li><tt>1</tt> represents the starting square.  There is exactly one starting square.</li>
 * <li><tt>2</tt> represents the ending square.  There is exactly one ending square.</li>
 * <li><tt>0</tt> represents empty squares we can walk over.</li>
 * <li><tt>-1</tt> represents obstacles that we cannot walk over.</li>
 * </ul>
 * Return the number of 4-directional walks from the starting square to the ending square, that <b>walk over every non-obstacle square exactly once</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= grid.length * grid[0].length <= 20</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 20.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(uniquePathsIII(new int[][] {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 } })); // 2
        System.out.println(uniquePathsIII(new int[][] {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 2 } })); // 4
        System.out.println(uniquePathsIII(new int[][] {
                { 0, 1 },
                { 2, 0 } }));       // 0
    }

    public static int uniquePathsIII(int[][] grid) {
        Data data = getTotalEmptySquares(grid);
        return dfs(grid, data.startRow, data.startCol, data.totalEmptySquares);
    }

    private static Data getTotalEmptySquares(int[][] grid) {
        Data res = new Data();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                res.totalEmptySquares += grid[row][col] == 0 ? 1 : 0;
                res.startRow = grid[row][col] == 1 ? row : res.startRow;
                res.startCol = grid[row][col] == 1 ? col : res.startCol;
            }
        }

        return res;
    }

    private static int dfs(int[][] grid, int row, int col, int totalEmptySquares) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length)
            return 0;
        if (grid[row][col] == -1 || grid[row][col] == 3)
            return 0;

        if (grid[row][col] == 2)
            if (totalEmptySquares == 0)
                return 1;

        if (grid[row][col] != 0 && grid[row][col] != 1)
            return 0;

        if (grid[row][col] == 0) {
            totalEmptySquares--;
            grid[row][col] = 3;
        } else
            grid[row][col] = 11;

        int res = 0;

        res += dfs(grid, row, col + 1, totalEmptySquares);
        res += dfs(grid, row + 1, col, totalEmptySquares);
        res += dfs(grid, row, col - 1, totalEmptySquares);
        res += dfs(grid, row - 1, col, totalEmptySquares);

        if (grid[row][col] == 3) {
            grid[row][col] = 0;
            totalEmptySquares++;
        }

        return res;
    }

    private static final class Data {

        int totalEmptySquares;
        int startRow;
        int startCol;
    }

}
