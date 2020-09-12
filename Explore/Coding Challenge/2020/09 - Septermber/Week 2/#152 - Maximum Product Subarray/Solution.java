/**
 * Given an integer array <tt>nums</tt>, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> [2,3,-2,4]
 * <b>Output:</b> 6
 * <b>Explanation:</b> [2,3] has the largest product 6.
 * </pre>
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> [-2,0,-1]
 * <b>Output:</b> 0
 * <b>Explanation:</b> The result cannot be 2, because [-2,-1] is not a subarray.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 12.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));          // 6
        System.out.println(maxProduct(new int[] { -2, 0, -1 }));            // 0
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4, 5 }));       // 20
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4, 5, -1 }));   // 240
        System.out.println(maxProduct(new int[] { 2, -5, -2, -4, 3 }));     // 24
        System.out.println(maxProduct(new int[] { -4, -3, -2 }));           // 12
    }

    public static int maxProduct(int[] nums) {
        int res = nums[0];

        for (int i = 1, min = nums[0], max = nums[0]; i < nums.length; i++) {
            int maxCur = Math.max(nums[i], nums[i] * (nums[i] > 0 ? max : min));
            int minCur = Math.min(nums[i], nums[i] * (nums[i] > 0 ? min : max));
            res = Math.max(res, maxCur);
            max = maxCur;
            min = minCur;
        }

        return res;
    }
}
