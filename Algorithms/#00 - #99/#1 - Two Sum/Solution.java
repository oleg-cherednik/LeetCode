import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return <b>indices</b> of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have <b>exactly</b> one solution, and you may not use the <i>same</i> element twice.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[<b>0</b>] + nums[<b>1</b>] = 2 + 7 = 9,
 * return [<b>0</b>, <b>1</b>].
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.08.2018
 */
public class Solution {
    public static void main(String... args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] { map.get(target - nums[i]), i };
            map.put(nums[i], i);
        }

        return null;
    }
}
