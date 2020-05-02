import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <pre>
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * </pre>
 * The minimum path sum from top to bottom is <tt>11</tt> (i.e., <b>2</b> + <b>3</b> + <b>5</b> + <b>1</b> = 11).
 * <p>
 * <b>Note:</b>
 * <p>
 * Bonus point if you are able to do this using only <tt>O(n)</tt> extra space, where n is the total number of rows in the triangle.
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3))));  // 11
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);

            for (int j = 0; j < row.size(); j++) {
                int left = get(triangle, i - 1, j - 1);
                int right = get(triangle, i - 1, j);
                int val = left == Integer.MAX_VALUE && right == Integer.MAX_VALUE ? row.get(j) : row.get(j) + Math.min(left, right);
                triangle.get(i).set(j, val);

                if (i == triangle.size() - 1)
                    res = Math.min(res, val);
            }
        }

        return res;
    }

    private static int get(List<List<Integer>> triangle, int row, int col) {
        if (row < 0 || row >= triangle.size())
            return Integer.MAX_VALUE;

        List<Integer> value = triangle.get(row);
        return col < 0 || col >= value.size() ? Integer.MAX_VALUE : value.get(col);
    }
}
