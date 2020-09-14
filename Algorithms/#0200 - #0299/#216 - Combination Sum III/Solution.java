import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find all possible combinations of <b>k</b> numbers that add up to a number <b>n</b>, given that only numbers from 1 to 9 can be used and each
 * combination should be a unique set of numbers.
 * <ul>
 * <b>Note:</b>
 * <li>All numbers will be positive integers.</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 12.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(combinationSum3Str(3, 7));   // [[1,2,4]]
        System.out.println(combinationSum3Str(3, 9));   // [[1,2,6], [1,3,5], [2,3,4]]
        System.out.println(combinationSum3Str(2, 18));  // []
    }

    private static String combinationSum3Str(int k, int n) {
        List<List<Integer>> res = combinationSum3(k, n);
        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (List<Integer> set : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(set.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }

        buf.append(']');
        return buf.toString();
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 0, new LinkedList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> combinationSum3(int k, int n, int sum, Deque<Integer> queue, List<List<Integer>> res) {
        if (queue.size() + 1 == k) {
            if (n - sum > queue.getLast() && n - sum <= 9) {
                queue.addLast(n - sum);
                res.add(new ArrayList<>(queue));
                queue.removeLast();
            }
        } else if (queue.size() + 1 < k) {
            for (int i = queue.isEmpty() ? 1 : queue.getLast() + 1; i <= 9 && 2 * i < n - sum; i++) {
                queue.addLast(i);
                combinationSum3(k, n, sum + i, queue, res);
                queue.removeLast();
            }
        }

        return res;
    }
}
