import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays of equal length <tt>target</tt> and <tt>arr</tt>.
 * <p>
 * In one step, you can select any <b>non-empty sub-array</b> of <tt>arr</tt> and reverse it. You are allowed to make any number of steps.
 * <p>
 * Return <tt>True</tt> if you can make <tt>arr</tt> equal to <tt>target</tt>, or <tt>False</tt> otherwise.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
 * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 * ,/pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: target = [1,12], arr = [12,1]
 * Output: true
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr doesn't have value 9 and it can never be converted to target.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
 * Output: true
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>target.length == arr.length</tt></li>
 * <li><tt>1 <= target.length <= 1000</tt></li>
 * <li><tt>1 <= target[i] <= 1000</tt></li>
 * <li><tt>1 <= arr[i] <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 30.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));         // true
        System.out.println(canBeEqual(new int[] { 7 }, new int[] { 7 }));                           // true
        System.out.println(canBeEqual(new int[] { 1, 12 }, new int[] { 12, 1 }));                   // true
        System.out.println(canBeEqual(new int[] { 3, 7, 9 }, new int[] { 3, 7, 11 }));              // false
        System.out.println(canBeEqual(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 }));   // true
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int val : target)
            map.put(val, map.getOrDefault(val, 0) + 1);

        for (int val : arr) {
            if (!map.containsKey(val))
                return false;
            if (map.get(val) == 1)
                map.remove(val);
            else
                map.put(val, map.get(val) - 1);
        }

        return map.isEmpty();
    }

}
