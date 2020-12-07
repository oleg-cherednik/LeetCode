import java.util.Arrays;

/**
 * Given a positive integer <tt>n</tt>, generate a square matrix filled with elements from <tt>1</tt> to <tt>n<sup>2</sup></tt> in spiral order.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(generateMatrixStr(1));  // [[1]]
        System.out.println(generateMatrixStr(2));  // [[1, 2],[4, 3]]
        System.out.println(generateMatrixStr(3));  // [[1, 2, 3],[8, 9, 4],[7, 6, 5]]
        System.out.println(generateMatrixStr(4));  // [[1, 2, 3, 4],[12, 13, 14, 5],[11, 16, 15, 6],[10, 9, 8, 7]]
    }

    public static String generateMatrixStr(int n) {
        int[][] matrix = generateMatrix(n);
        StringBuilder buf = new StringBuilder().append('[');

        for (int[] row : matrix) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(Arrays.toString(row));
        }

        return buf.append(']').toString();
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0;
        int col = 0;
        int i = 1;
        Direction dir = Direction.RIGHT;

        while (matrix[row][col] == 0) {
            matrix[row][col] = i++;

            if (dir == Direction.RIGHT) {
                if (col + 1 == matrix[row].length || matrix[row][col + 1] != 0) {
                    dir = Direction.DOWN;
                    row++;
                } else
                    col++;
            } else if (dir == Direction.DOWN) {
                if (row + 1 == matrix.length || matrix[row + 1][col] != 0) {
                    dir = Direction.LEFT;
                    col--;
                } else
                    row++;
            } else if (dir == Direction.LEFT) {
                if (col == 0 || matrix[row][col - 1] != 0) {
                    dir = Direction.UP;
                    row--;
                } else
                    col--;
            } else { // Direction.UP
                if (row == 0 || matrix[row - 1][col] != 0) {
                    dir = Direction.RIGHT;
                    col++;
                } else
                    row--;
            }

            if (row < 0 || row == matrix.length || col < 0 || col == matrix[row].length)
                break;
        }

        return matrix;
    }

    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

}
