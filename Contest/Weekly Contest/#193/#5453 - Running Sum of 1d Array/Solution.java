import java.util.Arrays;

/**
 * Given an array <tt>nums</tt>. We define a running sum of an array as <tt>runningSum[i] = sum(nums[0]…nums[i])</tt>.
 * <p>
 * Return the running sum of <tt>nums</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 1000</tt></li>
 * <li><tt>-10<sup>6</sup> <= nums[i] <= 10<sup>6</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));      // [1, 3, 6, 10]
        System.out.println(Arrays.toString(runningSum(new int[] { 1, 1, 1, 1, 1 })));   // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(runningSum(new int[] { 3, 1, 2, 10, 1 })));  // [3, 4, 6, 16, 17]
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            res[i] = res[i - 1] + nums[i];

        return res;
    }

}
