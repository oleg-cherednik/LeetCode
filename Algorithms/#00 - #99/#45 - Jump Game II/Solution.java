

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 * <b>Note:</b>
 * <p>
 * You can assume that you can always reach the last index.
 *
 * @author Oleg Cherednik
 * @since 21.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));  // 2
    }

    public static int jump(int[] nums) {
        int res = 0;
        int end = 0;
        int far = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (end < i) {
                res++;
                end = far;
            }

            far = Math.max(far, i + nums[i]);
        }

        return res;
    }

}
