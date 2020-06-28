import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string <tt>path</tt>, where <tt>path[i] = 'N'</tt>, <tt>'S'</tt>, <tt>'E'</tt> or <tt>'W'</tt>, each representing moving one unit north,
 * south, east, or west, respectively. You start at the origin <tt>(0, 0)</tt> on a 2D plane and walk on the path specified by <tt>path</tt>.
 * <p>
 * Return <tt>True</tt> if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited. Return
 * <tt>False</tt> otherwise.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="screen-shot-2020-06-10-at-123929-pm.png" />
 * <pre>
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="screen-shot-2020-06-10-at-123843-pm.png" />
 * <pre>
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= path.length <= 10<sup>4</sup></tt></li>
 * <li><tt>path</tt> will only consist of characters in <tt>{'N', 'S', 'E', 'W}</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 28.06.2s020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isPathCrossing("NES"));      // false
        System.out.println(isPathCrossing("NESWW"));    // true
    }

    public static boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(0);

        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);

            if (ch == 'N')
                y++;
            else if (ch == 'S')
                y--;
            else if (ch == 'E')
                x++;
            else if (ch == 'W')
                x--;
            else
                continue;

            if (map.getOrDefault(x, Collections.emptySet()).contains(y))
                return true;

            if (!map.containsKey(x))
                map.put(x, new HashSet<>());

            map.get(x).add(y);
        }

        return false;
    }

}
