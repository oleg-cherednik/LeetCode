/**
 * Given an array of integers <tt>nums</tt>, you start with an initial <b>positive</b> value startValue.
 * <p>
 * In each iteration, you calculate the step by step sum of startValue plus elements in <tt>nums</tt> (from left to right).
 * <p>
 * Return the minimum <b>positive</b> value of <i>startValue</i> such that the step by step sum is never less than 1.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
 *                 step by step sum
 *                 startValue = 4 | startValue = 5 | nums
 *                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: Minimum start value should be positive.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,-2,-3]
 * Output: 5
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 100</tt></li>
 * <li><tt>-100 <= nums[i] <= 100</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minStartValue(new int[] { -3, 2, -3, 4, 2 }));   // 5
        System.out.println(minStartValue(new int[] { 1, 2 }));              // 1
        System.out.println(minStartValue(new int[] { 1, -2, -3 }));         // 5
    }

    public static int minStartValue(int[] nums) {
        int res = 1;

        for (int i = 0, sum = 0; i < nums.length; i++)
            res = Math.max(res, 1 - (sum += nums[i]));

        return res;
    }
}
