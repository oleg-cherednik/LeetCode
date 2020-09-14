import java.util.Arrays;

/**
 * Given a matrix consists of <tt>0</tt> and <tt>1</tt>, find the distance of the nearest <tt>0</tt> for each cell.
 * <p>
 * The distance between two adjacent cells is <tt>1</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The number of elements of the given matrix will not exceed <tt>10,000</tt>.</li>
 * <li>There are at least one <tt>0</tt> in the given matrix.</li>
 * <li>The cells are adjacent in only four directions: up, down, left and right.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 01.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(updateMatrixStr(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } })); // [[0, 0, 0],[0, 1, 0],[0, 0, 0]]
        System.out.println(updateMatrixStr(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } })); // [[0, 0, 0],[0, 1, 0],[1, 2, 1]]
    }

    private static String updateMatrixStr(int[][] matrix) {
        matrix = updateMatrix(matrix);
        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int[] row : matrix) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(Arrays.toString(row));
        }

        buf.append(']');
        return buf.toString();
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                dfs(row, col, 0, matrix, res);

        return res;
    }

    private static void dfs(int row, int col, int distance, int[][] matrix, int[][] res) {
        if (distance == 0 && get(row, col, matrix) != 0)
            return;
        if (distance > 0 && get(row, col, matrix) != 1)
            return;
        if (get(row, col, res) == -1)
            return;
        if (get(row, col, res) > 0 && get(row, col, res) <= distance)
            return;

        res[row][col] = distance;

        dfs(row, col - 1, distance + 1, matrix, res);
        dfs(row, col + 1, distance + 1, matrix, res);
        dfs(row - 1, col, distance + 1, matrix, res);
        dfs(row + 1, col, distance + 1, matrix, res);
    }

    private static int get(int row, int col, int[][] matrix) {
        if (row < 0 || row >= matrix.length)
            return -1;
        if (col < 0 || col >= matrix[row].length)
            return -1;
        return matrix[row][col];
    }
}
