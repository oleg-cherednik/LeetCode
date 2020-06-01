import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Given an integer array <tt>arr</tt>, count element <tt>x</tt> such that <tt>x + 1</tt> is also in <tt>arr</tt>.
 * <p>
 * If there're duplicates in <tt>arr</tt>, count them seperately.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= arr.length <= 1000</tt></li>
 * <li><tt>0 <= arr[i] <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countElements(new int[] { 1, 2, 3 }));                   // 2
        System.out.println(countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 }));    // 0
        System.out.println(countElements(new int[] { 1, 3, 2, 3, 5, 0 }));          // 3
        System.out.println(countElements(new int[] { 1, 1, 2, 2 }));                // 2
        System.out.println(countElements(new int[] { 1, 1, 2 }));                   // 2
    }

    public static int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : arr)
            map.compute(value, (key, count) -> Optional.ofNullable(count).orElse(0) + 1);

        int res = 0;
        int[] keys = map.keySet().stream().mapToInt(i -> i).sorted().toArray();

        for (int i = 0; i < keys.length - 1; i++)
            if (keys[i] + 1 == keys[i + 1])
                res += map.get(keys[i]);

        return res;
    }
}
