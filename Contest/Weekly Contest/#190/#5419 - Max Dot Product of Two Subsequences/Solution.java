/**
 * Given two arrays <tt>nums1</tt> and <tt>nums2</tt>.
 * <p>
 * Return the maximum dot product between <b>non-empty</b> subsequences of <tt>nums1</tt> and <tt>nums2</tt> with the same length.
 * <p>
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, <tt>[2,3,5]</tt> is a subsequence of <tt>[1,2,3,4,5]</tt> while <tt>[1,5,3]</tt> is not).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums1 = [3,-2], nums2 = [2,-6,7]
 * Output: 21
 * Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
 * Their dot product is (3*7) = 21.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums1 = [-1,-1], nums2 = [1,1]
 * Output: -1
 * Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
 * Their dot product is -1.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums1.length, nums2.length <= 500</tt></li>
 * <li><tt>-1000 <= nums1[i], nums2[i] <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxDotProduct(new int[] { 2, 1, -2, 5 }, new int[] { 3, 0, -6 }));   // 18
        System.out.println(maxDotProduct(new int[] { 3, -2 }, new int[] { 2, -6, 7 }));         // 21
        System.out.println(maxDotProduct(new int[] { -1, -1 }, new int[] { 1, 1 }));            // -1
        System.out.println(maxDotProduct(new int[] { 7, 2, 2, -1, -1, 1, -4, 7, 6 }, new int[] { -7, -9, -1, 2, 2, 5, -7, 2, -7, 5 }));       // 108
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        long[][] dp = new long[nums1.length + 1][nums2.length + 1];

        for (int i = 0; i <= nums1.length; i++) {
            for (int j = 0; j <= nums2.length; j++) {
                dp[i][j] = Long.MIN_VALUE / 2;

                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], nums1[i - 1] * nums2[j - 1]);
                if (i - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                if (j - 1 >= 0 && i - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
            }
        }

        return (int)dp[nums1.length][nums2.length];
    }

}
