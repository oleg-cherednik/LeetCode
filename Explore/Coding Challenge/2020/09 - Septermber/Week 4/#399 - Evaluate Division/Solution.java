import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given equations in the format <tt>A / B = k</tt>, where <tt>A</tt> and <tt>B</tt> are variables represented as strings, and <tt>k</tt> is a
 * real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return <tt>-1.0</tt>.
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= equations.length <= 20</tt></li>
 * <li><tt>equations[i].length == 2</tt></li>
 * <li><tt>1 <= equations[i][0], equations[i][1] <= 5</tt></li>
 * <li><tt>values.length == equations.length</tt></li>
 * <li><tt>0.0 < values[i] <= 20.0</tt></li>
 * <li><tt>1 <= queries.length <= 20</tt></li>
 * <li><tt>queries[i].length == 2</tt></li>
 * <li><tt>1 <= queries[i][0], queries[i][1] <= 5</tt></li>
 * <li><tt>equations[i][0], equations[i][1], queries[i][0], queries[i][1]</tt> consist of lower case English letters and digits.</li>
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 27.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(calcEquation(
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
                new double[] { 2.0, 3.0 },
                Arrays.asList(
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "a"),
                        Arrays.asList("a", "e"),
                        Arrays.asList("a", "a"),
                        Arrays.asList("x", "x")))));    // [6.0, 0.5, -1.0, 1.0, -1.0]
        System.out.println(Arrays.toString(calcEquation(
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")),
                new double[] { 1.5, 2.5, 5.0 },
                Arrays.asList(
                        Arrays.asList("a", "c"),
                        Arrays.asList("c", "b"),
                        Arrays.asList("bc", "cd"),
                        Arrays.asList("cd", "bc")))));  // [3.75, 0.4, 5.0, 0.2]
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = creatMap(equations, values);
        double[] res = new double[queries.size()];

        for (int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            Deque<String> qa = new ArrayDeque<>();
            qa.add(query.get(0));
            String b = query.get(1);
            res[i] = dfs(qa, 1, b, 1, map);
        }

        return res;
    }

    private static double dfs(Deque<String> qa, double va, String b, double vb, Map<String, Map<String, Double>> map) {
        String a = qa.element();

        if (!map.containsKey(a) || !map.containsKey(b))
            return -1;
        if (a.equals(b))
            return va / vb;

        double res;

        for (Map.Entry<String, Double> entry : map.get(a).entrySet()) {
            if (qa.contains(entry.getKey()))
                continue;

            qa.push(entry.getKey());
            res = dfs(qa, va * entry.getValue(), b, vb, map);
            qa.pop();

            if (Double.compare(res, -1) != 0)
                return res;
        }

        return -1;
    }

    private static Map<String, Map<String, Double>> creatMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            if (!map.containsKey(a))
                map.put(a, new HashMap<>());
            if (!map.containsKey(b))
                map.put(b, new HashMap<>());

            map.get(a).put(b, val);
            map.get(b).put(a, 1 / val);
        }

        return map;
    }

}
