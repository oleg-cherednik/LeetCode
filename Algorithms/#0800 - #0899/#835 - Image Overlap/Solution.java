import java.util.Arrays;

/**
 * Two images <tt>A</tt> and <tt>B</tt> are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as
 * values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image. After,
 * the <i>overlap</i> of this translation is the number of positions that have a 1 in both images.
 * <p>
 * (Note also that a translation does <b>not</b> include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * </pre>
 * <ol>
 * <b>Notes:</b>
 * <li><tt>1 <= A.length = A[0].length = B.length = B[0].length <= 30</tt></li>
 * <li><tt>0 <= A[i][j], B[i][j] <= 1</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 07.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestOverlap(new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } },
                new int[][] { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } }));    // 3
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int[] bitsA = new int[A.length];
        int[] bitsBleft = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                bitsA[i] = (bitsA[i] << 1) + A[i][j];
                bitsBleft[i] = (bitsBleft[i] << 1) + B[i][j];
            }
        }

        int[] bitsBright = Arrays.copyOf(bitsBleft, A.length);
        int res = 0;

        for (int colShift = 0; colShift < A.length; colShift++) {
            for (int rowShift = -(A.length - 1); rowShift < 0; rowShift++) {
                int countLeft = 0;
                int countRight = 0;

                for (int rowA = 0, rowB = -rowShift; rowB < A.length; rowA++, rowB++) {
                    countLeft += Integer.bitCount(bitsA[rowA] & bitsBleft[rowB]);
                    countRight += Integer.bitCount(bitsA[rowA] & bitsBright[rowB]);
                }

                res = Math.max(res, Math.max(countLeft, countRight));
            }

            for (int rowShift = 0; rowShift < A.length; rowShift++) {
                int countLeft = 0;
                int countRight = 0;

                for (int rowA = rowShift, rowB = 0; rowA < A.length; rowA++, rowB++) {
                    countLeft += Integer.bitCount(bitsA[rowA] & bitsBleft[rowB]);
                    countRight += Integer.bitCount(bitsA[rowA] & bitsBright[rowB]);
                }

                res = Math.max(res, Math.max(countLeft, countRight));
            }

            for (int i = 0; i < A.length; i++) {
                bitsBleft[i] <<= 1;
                bitsBright[i] >>= 1;
            }
        }

        return res;
    }

}
