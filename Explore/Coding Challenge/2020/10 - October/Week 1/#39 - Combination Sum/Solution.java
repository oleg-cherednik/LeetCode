import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of <b>distinct</b> integers <tt>candidates</tt> and a target integer <tt>target</tt>, return <i>a list of all <b>unique
 * combinations</b> of <tt>candidates</tt> where the chosen numbers sum to <tt>target</tt></i>. You may return the combinations in <b>any order</b>.
 * <p>
 * The <b>same</b> number may be chosen from <tt>candidates</tt> an <b>unlimited number of times</b>. Two combinations are unique if the frequency of
 * at least one of the chosen numbers is different.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: candidates = [2], target = 1
 * Output: []
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 * </?pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= candidates.length <= 30</tt></li>
 * <li><tt>1 <= candidates[i] <= 200</tt></li>
 * <li>All elements of <tt>candidates</tt> are <b>distinct</b>.</li>
 * <li><tt>1 <= target <= 500</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));    // [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));       // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        System.out.println(combinationSum(new int[] { 2 }, 1));             // []
        System.out.println(combinationSum(new int[] { 1 }, 1));             // [[1]]
        System.out.println(combinationSum(new int[] { 1 }, 2));             // [[1, 1]]
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0, target, new LinkedList<>(), 0, new ArrayList<>());
    }

    private static List<List<Integer>> dfs(int[] candidates, int i, int target, Deque<Integer> queue, int sum, List<List<Integer>> res) {
        if (i == candidates.length || sum > target)
            return res;
        if (sum == target)
            res.add(new ArrayList<>(queue));
        else {
            for (int j = i; j < candidates.length; j++) {
                if (sum + candidates[j] > target)
                    break;

                queue.addLast(candidates[j]);
                sum += candidates[j];
                dfs(candidates, j, target, queue, sum, res);
                sum -= candidates[j];
                queue.removeLast();
            }
        }

        return res;
    }

}
