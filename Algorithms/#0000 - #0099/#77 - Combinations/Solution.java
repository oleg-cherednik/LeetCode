import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two integers <tt>n</tt> and <tt>k</tt>, return <i>all possible combinations of <tt>k</tt> numbers chosen from
 * the range <tt>[1, n]</tt></i>.
 * <p>
 * You may return the answer in <b>any order</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 20</tt></li>
 * <li><tt>1 <= k <= n</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(combine(4, 2));   // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
        System.out.println(combine(1, 1));   // [[1]]
    }

    public static List<List<Integer>> combine(int n, int k) {
        return combine(1, n, k, new LinkedList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> combine(int i, int n, int k, Deque<Integer> combination, List<List<Integer>> res) {
        if (combination.size() < k) {
            for (int j = i; j <= n; j++) {
                combination.addLast(j);
                combine(j + 1, n, k, combination, res);
                combination.removeLast();
            }
        } else
            res.add(List.copyOf(combination));

        return res;
    }

}
