

/**
 * Say you have an array for which the <tt>i<sup>th</sup></tt> element is the price of a given stock on day <tt>i</tt>.
 * <ul>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 * <li>You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).</li>
 * <li>After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)</li>
 * </ul>
 * <b>Example:</b>
 * <pre>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 30.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProfit(new int[] { 1, 2, 3, 0, 2 })); // 3
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        if (prices.length == 2)
            return prices[0] > prices[1] ? 0 : prices[1] - prices[0];

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]);
        dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][0];
    }

}
