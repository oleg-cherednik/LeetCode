/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up
 * that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: amount = 10, coins = [10]
 * Output: 1
 * </pre>
 * <b>Note:</b>
 * <ul>
 * You can assume that
 * <li><tt>0 <= amount <= 5000</tt></li>
 * <li><tt>1 <= coin <= 5000</tt></li>
 * <li>the number of coins is less than <tt>500</tt></li>
 * <li>the answer is guaranteed to fit into signed 32-bit integer</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 08.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(change(5, new int[] { 1, 2, 5 }));   // 4
        System.out.println(change(3, new int[] { 2 }));         // 0
        System.out.println(change(10, new int[] { 10 }));       // 1
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int j = 1; j <= coins.length; j++) {
            dp[j][0] = 1;

            for (int i = 1; i <= amount; i++) {
                dp[j][i] = dp[j - 1][i];

                if (i - coins[j - 1] >= 0)
                    dp[j][i] += dp[j][i - coins[j - 1]];
            }
        }

        return dp[coins.length][amount];
    }
}
