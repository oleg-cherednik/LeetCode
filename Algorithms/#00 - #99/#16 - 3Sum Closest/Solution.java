/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers and an integer target, find three integers in <tt>nums</tt> such that the <tt>sum</tt> is
 * closest to target. Return the <tt>sum</tt> of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); // 2
    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(sum - target) < Math.abs(res - target))
                        res = sum;
                }
            }
        }

        return res;
    }
}
