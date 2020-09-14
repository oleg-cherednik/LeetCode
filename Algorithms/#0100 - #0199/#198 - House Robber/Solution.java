/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint
 * stopping
 * you from robbing each of them is that adjacent houses have security system connected and <b>it will automatically contact the police if two
 * adjacent houses were broken into on the same night</b>.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight
 * <b>without alerting the police</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= nums.length <= 100</tt></li>
 * <li><tt>0 <= nums[i] <= 400</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rob(new int[] { 1, 2, 3, 1 }));      // 4
        System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));   // 12
        System.out.println(rob(new int[0]));                    // 0
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        for (int i = 1; i < nums.length; i++)
            nums[i] = i == 1 ? Math.max(nums[i], nums[i - 1]) : Math.max(nums[i - 1], nums[i - 2] + nums[i]);

        return nums[nums.length - 1];
    }

}
