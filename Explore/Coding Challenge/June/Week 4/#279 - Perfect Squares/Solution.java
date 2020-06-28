/**
 * Given a positive integer <tt>n</tt>, find the least number of perfect square numbers (for example, <tt>1, 4, 9, 16, ...</tt>) which sum to
 * <tt>n</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 28.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(numSquares(12)); //3
        System.out.println(numSquares(13)); //2
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            int near = (int)Math.sqrt(i);
            int min = dp[i - 1];

            for (int j = near; j > 0; j--)
                min = Math.min(dp[i - j * j], min);

            dp[i] = min + 1;
        }

        return dp[n];
    }

}
