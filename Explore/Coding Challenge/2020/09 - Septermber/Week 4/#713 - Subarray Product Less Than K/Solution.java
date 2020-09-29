/**
 * Your are given an array of positive integers <tt>nums</tt>.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than <tt>k</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>0 < nums.length <= 50000.</tt></li>
 * <li><tt>0 < nums[i] < 1000.</tt></li>
 * <li><tt>0 <= k < 10<sup>6</sup>.</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 29.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));                                    // 8
        System.out.println(numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));                                          // 0
        System.out.println(numSubarrayProductLessThanK(new int[] { 1, 1, 1 }, 1));                                          // 0
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 }, 19));    // 18
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;

        for (int i = 0, j = 0, prod = 1; j < nums.length; ) {
            prod *= nums[j++];

            while (prod >= k && i < j)
                prod /= nums[i++];

            res += j - i;
        }

        return res;
    }

}

