/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * <img src="island.png" />
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 07.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(islandPerimeter(new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 } }));  // 16
        System.out.println(islandPerimeter(new int[][] {
                { 0 },
                { 1 } }));  // 4
    }

    public static int islandPerimeter(int[][] grid) {
        int row = 0;
        int col = 0;

        out:
        for (row = 0; row < grid.length; row++)
            for (col = 0; col < grid[row].length; col++)
                if (grid[row][col] == 1)
                    break out;

        return dfs(grid, row, col, 0);
    }

    private static int dfs(int[][] grid, int row, int col, int count) {
        if (get(grid, row, col) != 1)
            return count;

        if (get(grid, row, col - 1) == 0)
            count++;
        if (get(grid, row, col + 1) == 0)
            count++;
        if (get(grid, row - 1, col) == 0)
            count++;
        if (get(grid, row + 1, col) == 0)
            count++;

        grid[row][col] = 2;

        count = dfs(grid, row, col - 1, count);
        count = dfs(grid, row, col + 1, count);
        count = dfs(grid, row - 1, col, count);
        count = dfs(grid, row + 1, col, count);

        return count;
    }

    private static int get(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length)
            return 0;
        if (col < 0 || col >= grid[row].length)
            return 0;
        return grid[row][col];
    }

}
