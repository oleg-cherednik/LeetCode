import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <img src-"PascalTriangleAnimated2.gif" />
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(generateAndPrint(5));    // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(generateAndPrint(0));    // []
    }

    private static String generateAndPrint(int numRows) {
        List<List<Integer>> res = generate(numRows);
        return res.stream()
                  .map(row -> row.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")))
                  .collect(Collectors.joining(",", "[", "]"));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));

        for (int i = 1, len = 2; i < numRows; i++, len++) {
            List<Integer> prv = res.get(i - 1);
            List<Integer> row = new ArrayList<>(len);

            for (int j = 0; j < len; j++)
                row.add(get(prv, j - 1) + get(prv, j));

            res.add(row);
        }

        return res;
    }

    private static int get(List<Integer> prv, int i) {
        return i < 0 || i >= prv.size() ? 0 : prv.get(i);
    }
}
