/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 * 1 0 1 0 0
 * 1 0 <b>1 1</b> 1
 * 1 1 <b>1 1</b> 1
 * 1 0 0 1 0
 * Output: 4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 27.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maximalSquare(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } }));    // 4
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == '1')
                    res = Math.max(res, square(i, j, 1, matrix));

        return res;
    }

    public static int square(int i, int j, int count, char[][] matrix) {
        while (true) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            if (i + 1 < 0 || i + 1 >= rows || j + 1 < 0 || j + 1 >= cols)
                return (int)Math.pow(count, 2);

            for (int k = 0; k <= count; k++)
                if (matrix[i + 1 - k][j + 1] == '0' || matrix[i + 1][j + 1 - k] == '0')
                    return (int)Math.pow(count, 2);

            count++;
            j++;
            i++;
        }
    }

}
