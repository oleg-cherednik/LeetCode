/**
 * Given a 2d grid map of <tt>'1'</tt>s (land) and <tt>'0'</tt>s (water), count the number of islands. An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));   // 1
        System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));   // 3
        System.out.println(numIslands(new char[][] { { '1', '1', '0' }, { '0', '1', '0' }, { '1', '1', '1' } }));   // 1
    }

    public static int numIslands(char[][] grid) {
        int total = 0;

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (visit(grid, row, col))
                    total++;

        return total;
    }

    private static boolean visit(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] != '1')
            return false;

        grid[row][col] = '2';
        visit(grid, row, col + 1);
        visit(grid, row, col - 1);
        visit(grid, row + 1, col);
        visit(grid, row - 1, col);
        return true;
    }
}
