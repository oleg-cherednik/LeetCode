/**
 * You are given an <tt>n x n</tt> 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * <b>Note:</b>
 * <p>
 * You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm">in-place</a>, which means you have to modify the input 2D
 * matrix directly. <b>DO NOT</b> allocate another 2D matrix and do the
 * rotation.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rotateToString(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));  // [[7,4,1],[8,5,2],[9,6,3]]
        System.out.println(rotateToString(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));
        // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }

    private static String rotateToString(int[][] matrix) {
        rotate(matrix);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int row = 0; row < matrix.length; row++) {
            if (row > 0)
                buf.append(',');

            buf.append('[');

            for (int col = 0; col < matrix[row].length; col++) {
                if (col != 0)
                    buf.append(',');
                buf.append(matrix[row][col]);
            }

            buf.append(']');
        }

        buf.append(']');
        return buf.toString();
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < matrix.length; i++, j--)
            for (int r1 = i, c1 = 0, r2 = matrix.length - 1, c2 = j; r1 >= 0; r1--, c1++, r2--, c2++)
                swap(matrix, r1, c1, r2, c2);

        for (int r1 = 0, r2 = matrix.length - 1; r1 <= r2; r1++, r2--)
            for (int c = 0; c < matrix.length; c++)
                swap(matrix, r1, c, r2, c);
    }

    private static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }

}
