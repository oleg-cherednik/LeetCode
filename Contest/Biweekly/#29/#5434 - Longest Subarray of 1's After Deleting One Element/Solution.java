/**
 * Given a binary array <tt>nums</tt>, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only <tt>1's</tt> in the resulting array.
 * <p>
 * Return <tt>0</tt> if there is no such subarray.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: nums = [1,1,0,0,1,1,1,0,1]
 * Output: 4
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: nums = [0,0,0]
 * Output: 0
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 10<sup>5</sup></tt></li>
 * <li><tt>nums[i]</tt> is either <tt>0</tt> or <tt>1</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 27.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestSubarray(new int[] { 1, 1, 0, 1 }));                  // 3
        System.out.println(longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));   // 5
        System.out.println(longestSubarray(new int[] { 1, 1, 1 }));                     // 2
        System.out.println(longestSubarray(new int[] { 1, 1, 0, 0, 1, 1, 1, 0, 1 }));   // 4
        System.out.println(longestSubarray(new int[] { 0, 0, 0 }));                     // 0
    }

    public static int longestSubarray(int[] nums) {
        int prv = -1;
        int sum = 0;
        int res = 0;

        for (int num : nums) {
            if (num == 1)
                sum++;
            else {
                if (prv != -1)
                    res = Math.max(res, prv + sum);

                res = Math.max(res, sum - 1);
                prv = sum;
                sum = 0;
            }
        }

        if (prv != -1)
            res = Math.max(res, prv + sum);

        res = Math.max(res, sum - 1);

        return res;
    }

}
