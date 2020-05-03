import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given the array <tt>paths</tt>, where <tt>paths[i] = [cityAi, cityBi]</tt> means there exists a direct path going from <tt>cityAi</tt> to
 * <tt>cityBi</tt>. <i>Return the destination city, that is, the city without any path outgoing to another city</i>.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York"
 * -> "Lima" -> "Sao Paulo".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= paths.length <= 100</tt></li>
 * <li><tt>paths[i].length == 2</tt></li>
 * <li><tt>1 <= cityAi.length, cityBi.length <= 10</tt></li>
 * <li><tt>cityAi != cityBi</tt></li>
 * <li>All strings consist of lowercase and uppercase English letters and the space character</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.05.2020
 */
public class Solution {

    public static void main(String... args) {
    }

    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

        for (List<String> path : paths)
            map.put(path.get(0), path.get(1));

        for (String city : map.values())
            if (!map.containsKey(city))
                return city;

        return null;
    }
}
