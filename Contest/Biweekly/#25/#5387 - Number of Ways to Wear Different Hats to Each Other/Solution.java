import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * There are <tt>n</tt> people and 40 types of hats labeled from 1 to 40.
 * <p>
 * Given a list of list of integers <tt>hats</tt>, where <tt>hats[i]</tt> is a list of all hats preferred by the <tt>i-th</tt> person.
 * <p>
 * Return the number of ways that the n people wear different hats to each other.
 * <p>
 * Since the answer may be too large, return it modulo <tt>10<sup>9</sup> + 7</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: hats = [[3,4],[4,5],[5]]
 * Output: 1
 * Explanation: There is only one way to choose hats given the conditions.
 * First person choose hat 3, Second person choose hat 4 and last one hat 5.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: hats = [[3,5,1],[3,5]]
 * Output: 4
 * Explanation: There are 4 ways to choose hats
 * (3,5), (5,3), (1,3) and (1,5)
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
 * Output: 24
 * Explanation: Each person can choose hats labeled from 1 to 4.
 * Number of Permutations of (1,2,3,4) = 24.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
 * Output: 111
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>n == hats.length</tt></li>
 * <li><tt>1 <= n <= 10</tt></li>
 * <li><tt>1 <= hats[i].length <= 40</tt></li>
 * <li><tt>1 <= hats[i][j] <= 40</tt></li>
 * <li><tt>hats[i]</tt> contains a list of <b>unique</b> integers.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numberWays(Arrays.asList(
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Collections.singletonList(5))));  // 1

        System.out.println(numberWays(Arrays.asList(
                Arrays.asList(3, 5, 1),
                Arrays.asList(3, 5))));  // 4

        System.out.println(numberWays(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4))));  // 24

        System.out.println(numberWays(Arrays.asList(
                Arrays.asList(4, 15, 16, 26, 28),
                Arrays.asList(1, 2, 3, 4, 6, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 25, 27, 28, 29, 30),
                Arrays.asList(1, 2, 3, 4, 5, 7, 9, 10, 11, 12, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30),
                Arrays.asList(2, 3, 6, 7, 14, 16, 17, 18, 19, 20, 21, 24, 25, 27, 28, 29),
                Arrays.asList(1, 10),
                Arrays.asList(1, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 19, 20, 21, 22, 24, 25, 27, 28),
                Arrays.asList(2, 5, 10, 14, 16, 19, 21, 22, 23, 27, 30))));

        System.out.println(numberWays(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 7, 9, 11, 12, 13, 17, 18, 19, 20, 21, 22, 23, 24, 25),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 18, 20, 21, 22, 24, 25),
                Arrays.asList(2, 3, 7, 12, 13, 15, 19, 22, 23, 24),
                Arrays.asList(6, 9, 11, 12, 14, 15, 16, 17, 20, 22, 24, 25),
                Collections.singletonList(10),
                Arrays.asList(19, 21, 24),
                Arrays.asList(1, 3, 5, 6, 8, 10, 11, 13, 14, 15, 16, 17, 18, 20, 22, 24, 25),
                Arrays.asList(3, 7, 9))));
    }

    public static int numberWays(List<List<Integer>> hats) {
        hats.sort(Comparator.comparingInt(List::size));

        long[] res = new long[1];
        long available = 0b1111111111_1111111111_1111111111_1111111111L;
        numberWays(hats, 0, res, available);
        return (int)res[0];
    }

    private static int numberWays(List<List<Integer>> hats, int i, long[] res, long available) {
        if (i >= hats.size())
            res[0] = (res[0] + 1) % 1_000_000_007;
        else if (available > 0) {
            for (int preferred : hats.get(i)) {
                long bit = 1L << preferred;

                if ((available & bit) != 0) {
                    available &= ~bit;
                    numberWays(hats, i + 1, res, available);
                    available |= bit;
                }
            }
        }

        return 0;
    }
}

