/**
 * Given a <b>circular array C</b> of integers represented by <tt>A</tt>, find the maximum possible sum of a non-empty subarray of <b>C</b>.
 * <p>
 * Here, a <i>circular array</i> means the end of the array connects to the beginning of the array. (Formally, <tt>C[i] = A[i]</tt> when <tt>0 <= i <
 * A.length</tt>, and <tt>C[i+A.length] = C[i]</tt> when <tt>i >= 0</tt>.)
 * <p>
 * Also, a subarray may only include each element of the fixed buffer A at most once. (Formally, for a subarray <tt>C[i], C[i+1], ..., C[j]</tt>,
 * there does not exist <tt>i <= k1, k2 <= j</tt> with <tt>k1 % A.length = k2 % A.length</tt>.)
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>-30000 <= A[i] <= 30000</tt></li>
 * <li><tt>1 <= A.length <= 30000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 15.05.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxSubarraySumCircular(new int[] { 2, -2, 2, 7, 8, 0 }));            // 19
        System.out.println(maxSubarraySumCircular(new int[] { 0, 5, 8, -9, 9, -7, 3, -2 }));    // 16
        System.out.println(maxSubarraySumCircular(new int[] { 1, 2, 3, -4, 5 }));               // 11
        System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));                 // 3
        System.out.println(maxSubarraySumCircular(new int[] { 5, -3, 5 }));                     // 10
        System.out.println(maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));                 // 4
        System.out.println(maxSubarraySumCircular(new int[] { 3, -2, 2, -3 }));                 // 3
        System.out.println(maxSubarraySumCircular(new int[] { -2, -3, -1 }));                   // -1
        System.out.println(maxSubarraySumCircular(new int[] { 3, 1, -4, 5 }));                  // 9
    }

    public static int maxSubarraySumCircular(int[] A) {
        if (A.length == 0)
            return 0;

        int res = A[0];

        int maxSoFar = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];
        int minSoFar = A[0];

        for (int i = 1; i < A.length; i++) {
            maxSoFar = Math.max(A[i], maxSoFar + A[i]);
            maxTotal = Math.max(maxSoFar, maxTotal);

            minSoFar = Math.min(A[i], minSoFar + A[i]);
            minTotal = Math.min(minTotal, minSoFar);

            res += A[i];
        }

        return res == minSoFar ? maxTotal : Math.max(res - minTotal, maxTotal);
    }
}
