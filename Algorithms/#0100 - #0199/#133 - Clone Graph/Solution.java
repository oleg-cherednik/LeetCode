import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Given a reference of a node in a <a href="https://en.wikipedia.org/wiki/Connectivity_(graph_theory)#Connected_graph">connected</a> undirected
 * graph.
 * <p>
 * Return a <a href="https://en.wikipedia.org/wiki/Object_copying#Deep_copy">deep copy</a> (clone) of the graph.
 * <p>
 * Each node in the graph contains a val (<tt>int</tt>) and a list (<tt>List[Node]</tt>) of its neighbors.
 * <pre>
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * </pre>
 * <p>
 * <b>Test case format:</b>
 * <p>
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with <tt>val = 1</tt>, the second
 * node with <tt>val = 2</tt>, and so on. The graph is represented in the test case using an adjacency list.
 * <p>
 * <b>Adjacency list</b> is a collection of unordered <b>lists</b> used to represent a finite graph. Each list describes the set of neighbors of a
 * node in the graph.
 * <p>
 * The given node will always be the first node with <tt>val = 1</tt>. You must return the <b>copy of the given node</b> as a reference to the cloned
 * graph.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="133_clone_graph_question.png" />
 * <pre>
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="graph.png" />
 * <pre>
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * </pre>
 * <b>Example 4:</b>
 * <p>
 * <img src="graph-1.png" />
 * <pre>
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= Node.val <= 100</tt></li>
 * <li><tt>Node.val</tt> is unique for each node.</li>
 * <li>Number of Nodes will not exceed 100.</li>
 * <li>There is no repeated edges and no self-loops in the graph.</li>
 * <li>The Graph is connected and all nodes can be visited starting from the given node.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 01.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(cloneGraphString(new int[][] { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } }));   // [[2,4],[1,3],[2,4],[1,3]]
        System.out.println(cloneGraphString(new int[][] { {} }));                                       // [[]]
        System.out.println(cloneGraphString(new int[][] {}));                                           // []
        System.out.println(cloneGraphString(new int[][] { { 2 }, { 1 } }));                             // [[2],[1]]
    }

    private static String cloneGraphString(int[][] adj) {
        Node node = build(adj);
        node = cloneGraph(node);
        return print(node);
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Integer, Node> nodes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.remove();

            if (visited.contains(n.val))
                continue;

            visited.add(n.val);

            if (!nodes.containsKey(n.val))
                nodes.put(n.val, new Node(n.val));

            for (Node neighbor : n.neighbors) {
                if (!nodes.containsKey(neighbor.val))
                    nodes.put(neighbor.val, new Node(neighbor.val));

                nodes.get(n.val).neighbors.add(nodes.get(neighbor.val));
                queue.add(neighbor);
            }
        }

        return nodes.get(1);
    }

    private static Node build(int[][] adj) {
        if (adj == null || adj.length == 0 || adj.length == 1 && adj[0] == null)
            return null;

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < adj.length; i++)
            nodes.put(i + 1, new Node(i + 1));

        for (int i = 0; i < adj.length; i++)
            for (int j : adj[i])
                nodes.get(i + 1).neighbors.add(nodes.get(j));

        return nodes.get(1);
    }

    private static String print(Node node) {
        if (node == null)
            return "[]";

        Map<Integer, Set<Integer>> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.remove();

            if (!map.containsKey(n.val)) {
                map.put(n.val, new TreeSet<>());

                for (Node neighbor : n.neighbors) {
                    map.get(n.val).add(neighbor.val);
                    queue.add(neighbor);
                }
            }
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        map.values().forEach(vertices -> {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(vertices.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        });

        buf.append(']');
        return buf.toString();
    }

    public static class Node {

        public int val;
        public List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

    }

}
