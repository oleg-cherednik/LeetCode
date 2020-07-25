import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a directed, acyclic graph of <tt>N</tt> nodes. Find all possible paths from node <tt>0</tt> to node <tt>N-1</tt>, and return them in any
 * order.
 * <p>
 * The graph is given as follows: the nodes are <tt>0, 1, ..., graph.length - 1</tt>. <tt>graph[i]</tt> is a list of all nodes <tt>j</tt> for which
 * the edge <tt>(i, j)</tt> exists.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The number of nodes in the graph will be in the range <tt>[2, 15]</tt>.</li>
 * <li>You can print different paths in any order, but you should keep the order of nodes inside one path.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 24.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsSourceTarget(graph, 0, new LinkedList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph, int i, Deque<Integer> path, List<List<Integer>> res) {
        path.addLast(i);

        if (i == graph.length - 1)
            res.add(new ArrayList<>(path));
        else {
            for (int next : graph[i])
                allPathsSourceTarget(graph, next, path, res);
        }

        path.removeLast();

        return res;
    }

}

