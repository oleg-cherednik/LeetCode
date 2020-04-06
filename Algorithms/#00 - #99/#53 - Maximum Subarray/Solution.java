/**
 * Given an integer array <tt>nums</tt>, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * <b>>Example:</b>
 * <pre>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * </pre>
 * <b>Follow up:</b>
 * <p>
 * If you have figured out the <tt>O(n)</tt> solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author Oleg Cherednik
 * @since 03.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));    // 6
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];

        for (int i = 1, sum = nums[0]; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }

        return max;
    }
}
