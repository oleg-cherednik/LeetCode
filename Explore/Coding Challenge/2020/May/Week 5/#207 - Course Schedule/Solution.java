import java.util.HashSet;
import java.util.Set;

/**
 * There are a total of <tt>numCourses</tt> courses you have to take, labeled from <tt>0</tt> to <tt>numCourses-1</tt>.
 * <p>
 * Some courses may have prerequisites, for example to take course <tt>0</tt> you have to first take course <tt>1</tt>, which is expressed as a pair:
 * <tt>[0,1]</tt>
 * <p>
 * Given the total number of courses and a list of prerequisite <b>pairs</b>, is it possible for you to finish all courses?
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The input prerequisites is a graph represented by <b>a list of edges</b>, not adjacency matrices. Read more about
 * <a href="https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs">how a graph is
 * represented</a>.</li>
 * <li>You may assume that there are no duplicate edges in the input prerequisites.</li>
 * <li><tt>1 <= numCourses <= 10<sup>5</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 29.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(canFinish(2, new int[][] { { 0, 1 } }));                                         // true
        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));                               // false
        System.out.println(canFinish(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 } }));           // true
        System.out.println(canFinish(4, new int[][] { { 2, 0 }, { 1, 0 }, { 3, 1 }, { 3, 2 }, { 1, 3 } })); // false

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] adj = buildAdjacencyList(numCourses, prerequisites);
        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < visited.length; i++)
            if (!dfs(i, adj, visited))
                return false;

        return true;
    }

    private static boolean dfs(int i, Node[] adj, boolean[] visited) {
        if (visited[i])
            return false;

        visited[i] = true;

        for (int linked : adj[i].linked)
            if (!dfs(linked, adj, visited))
                return false;

        visited[i] = false;

        return true;
    }

    private static Node[] buildAdjacencyList(int numCourses, int[][] prerequisites) {
        Node[] adj = new Node[numCourses];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new Node();

        for (int[] prerequisite : prerequisites)
            adj[prerequisite[0]].linked.add(prerequisite[1]);

        return adj;
    }

    private static final class Node {

        private final Set<Integer> linked = new HashSet<>();

    }
}
