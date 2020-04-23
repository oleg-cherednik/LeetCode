import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer <b>k</b>, you need to find the total number of continuous subarrays whose sum equals to <b>k</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The length of the array is in range [1, 20,000].</li>
 * <li>The range of numbers in the array is [-1000, 1000] and the range of the integer <b>k</b> is [-1e7, 1e7].</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 22.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));      // 2
        System.out.println(subarraySum(new int[] { 1 }, 0));            // 0
        System.out.println(subarraySum(new int[] { -1, -1, 1 }, 0));    // 1
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

}
