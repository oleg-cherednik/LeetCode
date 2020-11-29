import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * A tree is an undirected graph in which any two vertices are connected by <i>exactly</i> one path. In other words, any connected graph without
 * simple cycles is a tree.
 * <p>
 * Given a tree of <tt>n</tt> nodes labelled from <tt>0</tt> to <tt>n - 1</tt>, and an array of <tt>n - 1 edges</tt> where <tt>edges[i] =
 * [a<sub>i</sub>, b<sub>i</sub>]</tt> indicates that there is an undirected edge between the two nodes <tt>a<sub>i</sub></tt> and
 * <tt>b<sub>i</sub></tt> in the tree, you can choose any node of the tree as the root. When you select a node <tt>x</tt> as the root, the result
 * tree has height <tt>h</tt>. Among all possible rooted trees, those with minimum height (i.e. <tt>min(h)</tt>) are called <b>minimum height
 * trees</b> (MHTs).
 * <p>
 * Return a <i>list of all <b>MHTs'</b> root labels</i>. You can return the answer in <b>any order</b>.
 * <p>
 * The <b>height</b> of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="e1.jpg" />
 * <pre>
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="e2.jpg" />
 * <pre>
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 1, edges = []
 * Output: [0]
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 2 * 10<sup>4</sup></tt></li>
 * <li><tt>edges.length == n - 1</tt></li>
 * <li><tt>0 <= a<sub>i</sub>, b<sub>i</sub> < n</tt></li>
 * <li><tt>a<sub>i</sub> != b<sub>i</sub></tt></li>
 * <li>All the pairs <tt>(a<sub>i</sub>, b<sub>i</sub>)</tt> are distinct.</li>
 * <li>The given input is <b>guaranteed</b> to be a tree and there will be <b>no repeated</b> edges.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 29.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));                        // [1]
        System.out.println(findMinHeightTrees(6, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } }));    // [3, 4]
        System.out.println(findMinHeightTrees(1, new int[][] {}));                                                      // [0]
        System.out.println(findMinHeightTrees(2, new int[][] { { 0, 1 } }));                                            // [0, 1]
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0)
            return Collections.emptyList();
        if (n == 1)
            return Collections.singletonList(0);

        Map<Integer, Set<Integer>> adj = buildAdjacencyList(n, edges);
        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.remove();
                int neighbor = adj.get(leaf).iterator().next();

                adj.get(neighbor).remove(leaf);

                if (adj.get(neighbor).size() == 1)
                    leaves.add(neighbor);
            }
        }

        return new ArrayList<>(leaves);
    }

    private static Map<Integer, Set<Integer>> buildAdjacencyList(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(i, new HashSet<>());

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return map;
    }
}
