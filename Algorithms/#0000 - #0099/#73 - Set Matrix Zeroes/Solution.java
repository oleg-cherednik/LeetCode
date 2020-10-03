import java.util.Arrays;

/**
 * Given an <tt>m x n</tt> matrix. If an element is <b>0</b>, set its entire row and column to <b>0</b>. Do it <a
 * href="https://en.wikipedia.org/wiki/In-place_algorithm">in-place</a>.
 * <ul>
 * <b>Follow up:</b>
 * <li>A straight forward solution using <tt>O(mn)</tt> space is probably a bad idea.</li>
 * <li>A simple improvement uses <tt>O(m + n)</tt> space, but still not the best solution.</li>
 * <li>Could you devise a constant space solution?</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="mat1.jpg" />
 * <pre>
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="mat2.jpg" />
 * <pre>
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>m == matrix.length</tt></li>
 * <li><tt>n == matrix[0].length</tt></li>
 * <li><tt>1 <= m, n <= 200</tt></li>
 * <li><tt>-2<sup>31</sup> <= matrix[i][j] <= 2<sup>31</sup> - 1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(setZeroesStr(new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } }));    // [[1, 0, 1],[0, 0, 0],[1, 0, 1]]
        System.out.println(setZeroesStr(new int[][] {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } })); // [[0, 0, 0, 0],[0, 4, 5, 0],[0, 3, 1, 0]]
    }

    private static String setZeroesStr(int[][] matrix) {
        setZeroes(matrix);

        StringBuilder buf = new StringBuilder().append('[');

        for (int[] row : matrix) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(Arrays.toString(row));
        }

        return buf.append(']').toString();
    }

    public static void setZeroes(int[][] matrix) {
        boolean isCol = false;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                isCol = true;

            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++)
            for (int col = 1; col < matrix[row].length; col++)
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;

        if (matrix[0][0] == 0)
            Arrays.fill(matrix[0], 0);

        if (isCol)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }

}
