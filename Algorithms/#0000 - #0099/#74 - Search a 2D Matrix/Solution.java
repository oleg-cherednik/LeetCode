/**
 * <ul>
 * Write an efficient algorithm that searches for a value in an <tt>m x n</tt> matrix. This matrix has the following properties:
 * <li>Integers in each row are sorted from left to right.</li>
 * <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 * <b>Example 1:</b>
 * <p>
 * <img src="mat.jpg" />
 * <pre>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="mat2.jpg" />
 * <pre>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: matrix = [], target = 0
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>m == matrix.length</tt></li>
 * <li><tt>n == matrix[i].length</tt></li>
 * <li><tt>0 <= m, n <= 100</tt></li>
 * <li><tt>-10<sup>4</sup> <= matrix[i][j], target <= 10<sup>4</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(searchMatrix(new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 } }, 3));  // true
        System.out.println(searchMatrix(new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 } }, 13));  // false
        System.out.println(searchMatrix(new int[0][0], 0));  // false
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            if (get(matrix, l) == target)
                return true;

            int mid = (l + r) / 2;
            int val = get(matrix, mid);

            if (val < target)
                l = mid + 1;
            else if (val > target)
                r = mid - 1;
            else if (val == target)
                return true;
        }

        return false;
    }

    private static int get(int[][] matrix, int pos) {
        int row = pos / matrix[0].length;
        int col = pos % matrix[0].length;
        return matrix[row][col];
    }

}
