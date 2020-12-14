/**
 * Given <tt>n</tt> balloons, indexed from <tt>0</tt> to <tt>n-1</tt>. Each balloon is painted with a number on it represented by array
 * <tt>nums</tt>. You are asked to burst all the balloons. If the you burst balloon <tt>i</tt> you will get <tt>nums[left] * nums[i] *
 * nums[right]</tt> coins. Here left and right are adjacent indices of <tt>i</tt>. After the burst, the <tt>left</tt> and <tt>right</tt> then becomes
 * adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <ul>
 * <b>Note:</b>
 * <li>You may imagine <tt>nums[-1] = nums[n] = 1</tt>. They are not real therefore you can not burst them.</li>
 * <li><tt>0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100</tt></li>
 * </ul>
 * <b>Example:</b>
 * <pre>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxCoins(new int[] { 3, 1, 5, 8 }));    // 167
    }

    public static int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++)
            dp[i][i] = left(nums, i) * nums[i] * right(nums, i);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0, k = i; k < nums.length; k++, j++) {
                int left = left(nums, j);
                int right = right(nums, k);
                int one = dp[j + 1][k] + (left * nums[j] * right);
                int two = dp[j][k - 1] + (left * nums[k] * right);
                dp[j][k] = Math.max(one, two);

                for (int m = j + 1; m < k; m++) {
                    int sum = dp[j][m - 1] + dp[m + 1][k];
                    dp[j][k] = Math.max(dp[j][k], left * nums[m] * right + sum);
                }
            }
        }

        return dp[0][nums.length - 1];
    }

    private static int left(int[] nums, int i) {
        return i == 0 ? 1 : nums[i - 1];
    }

    private static int right(int[] nums, int i) {
        return i + 1 == nums.length ? 1 : nums[i + 1];
    }

}
