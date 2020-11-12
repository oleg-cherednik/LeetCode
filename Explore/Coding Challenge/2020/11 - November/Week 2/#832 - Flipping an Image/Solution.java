import java.util.Arrays;

/**
 * Given a binary matrix <tt>A</tt>, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping <tt>[1, 1, 0]</tt> horizontally results in
 * <tt>[0, 1, 1]</tt>.
 * <p>
 * To invert an image means that each <tt>0</tt> is replaced by <tt>1</tt>, and each <tt>1</tt> is replaced by <tt>0</tt>. For example, inverting
 * <tt>[0, 1, 1]</tt> results in <tt>[1, 0, 0]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * </pre>
 * <ul>
 * <b>Notes:</b>
 * <li><tt>1 <= A.length = A[0].length <= 20</tt></li>
 * <li><tt>0 <= A[i][j] <= 1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(flipAndInvertImageStr(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }));   // [[1,0,0],[0,1,0],[1,1,1]]
        System.out.println(flipAndInvertImageStr(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 },
                { 1, 0, 1, 0 } })); // [[1, 1, 0, 0],[0, 1, 1, 0],[0, 0, 0, 1],[1, 0, 1, 0]]
    }

    private static String flipAndInvertImageStr(int[][] A) {
        A = flipAndInvertImage(A);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int[] row : A) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(Arrays.toString(row));
        }

        return buf.append(']').toString();
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            for (int i = 0, j = row.length - 1; i <= j; i++, j--) {
                if (i == j)
                    invert(row, i);
                else {
                    swap(row, i, j);
                    invert(row, i);
                    invert(row, j);
                }
            }
        }

        return A;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void invert(int[] arr, int i) {
        arr[i] = arr[i] == 0 ? 1 : 0;
    }

}
