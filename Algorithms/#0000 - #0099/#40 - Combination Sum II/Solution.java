import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (<tt>candidates</tt>) and a target
 * number (<tt>target</tt>), find all unique combinations in <tt>candidates</tt>
 * where the candidate numbers sum to <tt>target</tt>.
 * <p>
 * Each number in <tt>candidates</tt> may only be used once in the combination.
 * <p>
 * <b>Note:</b> The solution set must not contain duplicate combinations.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 *  [1,1,6],
 *  [1,2,5],
 *  [1,7],
 *  [2,6]
 * ]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= candidates.length <= 100</tt></li>
 * <li><tt>1 <= candidates[i] <= 50</tt></li>
 * <li><tt>1 <= target <= 30</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.08.2025
 */
public class Solution {

    public static void main(String... args) {
        // [[1, 2, 5], [1, 6, 1], [1, 7], [2, 6]]
        System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        // [[5], [1, 2, 2]]
        System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));

        System.out.println(combinationSum2(new int[] {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 30));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        candidates = reduceCandidates(candidates, target);
        Map<Integer, Long> map = groupByValue(candidates);
        int[] uniqueCandidates = map.keySet().stream().mapToInt(i -> i).sorted().toArray();
        return dfs(uniqueCandidates, map, 0, target, new LinkedList<>(), new ArrayList<>());
    }

    private static int[] reduceCandidates(int[] candidates, int target) {
        return Arrays.stream(candidates, 0, candidates.length)
                     .filter(candidate -> candidate <= target)
                     .sorted().toArray();
    }

    private static Map<Integer, Long> groupByValue(int[] candidates) {
        return Arrays.stream(candidates).boxed()
                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static List<List<Integer>> dfs(int[] uniqueCandidates,
                                           Map<Integer, Long> map,
                                           int j,
                                           int sum,
                                           Deque<Integer> queue,
                                           List<List<Integer>> res) {
        if (sum == 0)
            res.add(new ArrayList<>(queue));
        if (sum <= 0)
            return res;

        for (int i = j; i < uniqueCandidates.length; i++) {
            int candidate = uniqueCandidates[i];

            if (sum < candidate)
                return res;

            final long count = map.get(candidate);

            if (count <= 0)
                continue;

            queue.add(candidate);
            map.put(candidate, count - 1);
            sum -= candidate;

            dfs(uniqueCandidates, map, count == 1 ? i + 1 : i, sum, queue, res);

            sum += candidate;
            map.put(candidate, count);
            queue.removeLast();
        }

        return res;
    }

}
