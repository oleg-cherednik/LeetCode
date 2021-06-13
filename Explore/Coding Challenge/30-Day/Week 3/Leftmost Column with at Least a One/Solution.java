import java.util.Arrays;
import java.util.List;

/**
 * <i>(This problem is an <b>interactive problem</b>.)</i>
 * <p>
 * A binary matrix means that all elements are <tt>0</tt> or <tt>1</tt>. For each <b>individual</b> row of the matrix, this row is sorted in
 * non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix <i>binaryMatrix</i>, return leftmost column index(0-indexed) with at least a <tt>1</tt> in it. If such index
 * doesn't exist, return <tt>-1</tt>.
 * <ul>
 * <b>You can't access the Binary Matrix directly.</b> You may only access the matrix using a <tt>BinaryMatrix</tt> interface:
 * <li><tt>BinaryMatrix.get(row, col)</tt> returns the element of the matrix at index <tt>(row, col)</tt> (0-indexed).</li>
 * <li><tt>BinaryMatrix.dimensions()</tt> returns a list of 2 elements <tt>[rows, cols]</tt>, which means the matrix is <tt>rows * cols</tt>.</li>
 * </ul>
 * Submissions making more than <tt>1000</tt> calls to <tt>BinaryMatrix.get</tt> will be judged Wrong <i>Answer</i>. Also, any solutions that attempt
 * to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix <tt>mat</tt> as input in the following four examples. You will not have access the
 * binary matrix directly.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="untitled-diagram-5.jpg" />
 * <pre>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="untitled-diagram-4.jpg" />
 * <pre>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="untitled-diagram-3.jpg" />
 * <pre>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * </pre>
 * <b>Example 4:</b>
 * <p>
 * <img src="untitled-diagram-6.jpg" />
 * <pre>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= mat.length, mat[i].length <= 100</tt></li>
 * <li><tt>mat[i][j]</tt> is either <tt>0</tt> or <tt>1</tt>.</li>
 * <li><tt>mat[i]</tt> is sorted in a non-decreasing way.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 21.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(leftMostColumnWithOne(new int[][] { { 0, 0 }, { 1, 1 } }));  // 0
        System.out.println(leftMostColumnWithOne(new int[][] { { 0, 0 }, { 0, 1 } }));  // 1
        System.out.println(leftMostColumnWithOne(new int[][] { { 0, 0 }, { 0, 0 } }));  // -1
        System.out.println(leftMostColumnWithOne(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } }));  // 1
    }

    private static int leftMostColumnWithOne(int[][] matrix) {
        return leftMostColumnWithOne(new BinaryMatrix() {
            @Override
            public int get(int row, int col) {
                return matrix[row][col];
            }

            @Override
            public List<Integer> dimensions() {
                return Arrays.asList(matrix.length, matrix[0].length);
            }
        });
    }

    private interface BinaryMatrix {

        int get(int row, int col);

        List<Integer> dimensions();
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int res = -1;

        for (int row = 0; row < rows; row++) {
            int pos = findFirstOne(row, 0, Math.max(res, cols - 1), binaryMatrix);

            if (pos != -1)
                res = res == -1 ? pos : Math.min(res, pos);
        }

        return res;
    }

    private static int findFirstOne(int row, int l, int r, BinaryMatrix binaryMatrix) {
        if (l == r)
            return binaryMatrix.get(row, l) == 1 ? l : -1;

        int m = (l + r) / 2;
        int val = binaryMatrix.get(row, m);
        return val == 0 ? findFirstOne(row, m + 1, r, binaryMatrix) : findFirstOne(row, l, m, binaryMatrix);
    }

}
