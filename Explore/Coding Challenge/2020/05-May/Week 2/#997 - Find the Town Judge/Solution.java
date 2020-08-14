import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In a town, there are <tt>N</tt> people labelled from <tt>1</tt> to <tt>N</tt>. There is a rumor that one of these people is secretly the town
 * judge.
 * <ol>
 * If the town judge exists, then:
 * <li>The town judge trusts nobody.</li>
 * <li>Everybody (except for the town judge) trusts the town judge.</li>
 * <li>There is exactly one person that satisfies properties 1 and 2.</li>
 * </ol>
 * You are given <tt>trust</tt>, an array of pairs <tt>trust[i] = [a, b]</tt> representing that the person labelled <tt>a</tt> trusts the person
 * labelled <tt>b</tt>.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge. Otherwise, return <tt>-1</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>1 <= N <= 1000</tt></li>
 * <li><tt>trust.length <= 10000</tt></li>
 * <li><tt>trust[i]</tt> are all different</li>
 * <li><tt>trust[i][0] != trust[i][1]</tt></li>
 * <li><tt>1 <= trust[i][0], trust[i][1] <= N</tt></li>
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 10.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findJudge(2, new int[][] { { 1, 2 } }));                                         // 2
        System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));                               // 3
        System.out.println(findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));                     // -1
        System.out.println(findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } }));                               // -1
        System.out.println(findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } })); // 3
    }

    public static int findJudge(int N, int[][] trust) {
        Set<Integer> candidates = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] pair : trust) {
            candidates.remove(pair[0]);
            map.compute(pair[1], (key, count) -> Optional.ofNullable(count).orElse(0) + 1);
        }

        int total = 0;
        int res = 0;

        for (int candidate : candidates) {
            if (map.getOrDefault(candidate, 0) != N - 1)
                continue;

            total++;
            res = candidate;
        }

        return total == 1 ? res : -1;
    }
}
