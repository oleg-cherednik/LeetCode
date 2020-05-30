import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of <tt>n</tt> courses you have to take, labeled from <tt>0</tt> to <tt>n-1</tt>.
 * <p>
 * Some courses may have direct prerequisites, for example, to take course <tt>0</tt> you have first to take course <tt>1</tt>, which is expressed as
 * a pair: <tt>[1,0]</tt>
 * <p>
 * Given the total number of courses <tt>n</tt>, a list of direct <tt>prerequisite</tt> <b>pairs</b> and a list of <tt>queries</tt> <b>pairs</b>.
 * <p>
 * You should answer for each <tt>queries[i]</tt> whether the course <tt>queries[i][0]</tt> is a prerequisite of the course <tt>queries[i][1]</tt> or
 * not.
 * <p>
 * Return a <i>list of boolean</i>, the answers to the given <tt>queries</tt>.
 * <p>
 * Please note that if course <b>a</b> is a prerequisite of course <b>b</b> and course <b>b</b> is a prerequisite of course <b>c</b>, then, course
 * <b>a</b> is a prerequisite of course <b>c</b>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="graph.png" />
 * <pre>
 * Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * Output: [false,true]
 * Explanation: course 0 is not a prerequisite of course 1 but the opposite is true.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * Output: [false,false]
 * Explanation: There are no prerequisites and each course is independent.
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="graph-1.png" />
 * <pre>
 * Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * Output: [true,true]
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
 * Output: [false,true]
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
 * Output: [true,false,true,false]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= n <= 100</tt></li>
 * <li><tt>0 <= prerequisite.length <= (n * (n - 1) / 2)</tt></li>
 * <li><tt>0 <= prerequisite[i][0], prerequisite[i][1] < n</tt></li>
 * <li><tt>prerequisite[i][0] != prerequisite[i][1]</tt></li>
 * <li>The prerequisites graph has no cycles.</li>
 * <li>The prerequisites graph has no repeated edges.</li>
 * <li><tt>1 <= queries.length <= 10<sup>4</sup></tt></li>
 * <li><tt>queries[i][0] != queries[i][1]</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 30.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkIfPrerequisite(2, new int[][] { { 1, 0 } }, new int[][] { { 0, 1 }, { 1, 0 } }));   // [false, true]
        System.out.println(checkIfPrerequisite(2, new int[][] {}, new int[][] { { 1, 0 }, { 0, 1 } }));             // [false, false]
        System.out.println(checkIfPrerequisite(3, new int[][] { { 1, 2 }, { 1, 0 }, { 2, 0 } }, new int[][] { { 1, 0 }, { 1, 2 } })); // [true, true]
        System.out.println(checkIfPrerequisite(3, new int[][] { { 1, 0 }, { 2, 0 } }, new int[][] { { 0, 1 }, { 2, 0 } })); // [false, true]
        System.out.println(checkIfPrerequisite(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } },
                new int[][] { { 0, 4 }, { 4, 0 }, { 1, 3 }, { 3, 0 } }));   // [true, false, true, false]
    }

    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Course[] courses = buildCourses(n, prerequisites);
        Map<Integer, Set<Integer>> map = buildPrerequisites(courses);

        List<Boolean> res = new ArrayList<>(queries.length);

        for (int[] query : queries)
            res.add(map.getOrDefault(query[0], Collections.emptySet()).contains(query[1]));

        return res;
    }

    private static Map<Integer, Set<Integer>> buildPrerequisites(Course[] courses) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (Course course : courses) {
            Set<Integer> prerequisites = new HashSet<>();
            dfs(course.num, courses, prerequisites);
            map.put(course.num, prerequisites);
        }

        return map;
    }

    private static void dfs(int num, Course[] courses, Set<Integer> prerequisites) {
        if (prerequisites.contains(num))
            return;

        prerequisites.add(num);

        for (int p : courses[num].prerequisites)
            dfs(p, courses, prerequisites);
    }

    private static Course[] buildCourses(int n, int[][] prerequisites) {
        Course[] courses = new Course[n];

        for (int i = 0; i < courses.length; i++)
            courses[i] = new Course(i);

        for (int[] prerequisite : prerequisites)
            courses[prerequisite[0]].prerequisites.add(prerequisite[1]);

        return courses;
    }

    private static final class Course {

        private final int num;
        private final Set<Integer> prerequisites = new HashSet<>();

        public Course(int num) {
            this.num = num;
        }

    }

}
