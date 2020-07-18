import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of <tt>n</tt> courses you have to take, labeled from <tt>0</tt> to <tt>n-1</tt>.
 * <p>
 * Some courses may have prerequisites, for example to take course <tt>0</tt> you have to first take course <tt>1</tt>, which is expressed as a pair:
 * <tt>[0,1]</tt>
 * <p>
 * Given the total number of courses and a list of prerequisite <b>pairs</b>, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The input prerequisites is a graph represented by <b>a list of edges</b>, not adjacency matrices. Read more about
 * <a href="https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs">how a graph is represented</a>.</li>
 * <li>You may assume that there are no duplicate edges in the input prerequisites.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 18.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));                                // [0, 1]
        System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));  // [0, 1, 2, 3]
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[1]))
                map.put(prerequisite[1], new ArrayList<>());

            map.get(prerequisite[1]).add(prerequisite[0]);
            arr[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                queue.add(i);

        if (queue.isEmpty())
            return new int[0];

        int i = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[i++] = course;

            if (map.get(course) == null)
                continue;

            for (int nextCourse : map.get(course)) {
                arr[nextCourse]--;

                if (arr[nextCourse] == 0)
                    queue.add(nextCourse);
            }
        }

        return i < res.length ? new int[0] : res;
    }
}
