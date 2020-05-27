import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of <tt>N</tt> people (numbered <tt>1, 2, ..., N</tt>), we would like to split everyone into two groups of <b>any</b> size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if <tt>dislikes[i] = [a, b]</tt>, it means it is not allowed to put the people numbered <tt>a</tt> and <tt>b</tt> into the same group.
 * <p>
 * Return <tt>true</tt> if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= N <= 2000</tt></li>
 * <li><tt>0 <= dislikes.length <= 10000</tt></li>
 * <li><tt>1 <= dislikes[i][j] <= N</tt></li>
 * <li><tt>dislikes[i][0] < dislikes[i][1]</tt></li>
 * <li>There does not exist <tt>i != j</tt> for which <tt>dislikes[i] == dislikes[j]</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 27.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(possibleBipartition(4, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }));                       // true
        System.out.println(possibleBipartition(3, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));                       // false
        System.out.println(possibleBipartition(5, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }));   // false
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        return checkCycle(constructGraph(N + 1, dislikes));
    }

    private static boolean checkCycle(Node[] graph) {
        int[] colors = new int[graph.length];

        for (int i = 1; i < colors.length; i++)
            if (colors[i] == 0 && !dfs(graph, colors, i, 1))
                return false;

        return true;
    }

    private static boolean dfs(Node[] graph, int[] colors, int currentVertex, int color) {
        if (colors[currentVertex] != 0)
            return colors[currentVertex] == color;

        colors[currentVertex] = color;

        for (int adj : graph[currentVertex].children)
            if (!dfs(graph, colors, adj, -color))
                return false;

        return true;
    }

    private static Node[] constructGraph(int N, int[][] edges) {
        Node[] graph = new Node[N];

        for (int i = 1; i < N; i++)
            graph[i] = new Node();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].children.add(v);
            graph[v].children.add(u);
        }

        return graph;
    }

    private static final class Node {

        private final Set<Integer> children = new HashSet<>();

    }
}
