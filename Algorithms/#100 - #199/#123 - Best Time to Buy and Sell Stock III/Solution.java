/**
 * Say you have an array for which the <i>i<sup>th</sup></i> element is the price of a given stock on day <i>i</i>.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most <i>two</i> transactions.
 * <p>
 * <b>Note:</b> You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you
 * buy again).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 16.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));    // 6
        System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));             // 4
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));             // 0
        System.out.println(maxProfit(new int[0]));                              // 0
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[][] arr = new int[2][prices.length];

        for (int i = 1, min = prices[0]; i < prices.length; i++) {
            arr[0][i] = Math.max(arr[0][i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        for (int i = prices.length - 2, max = prices[prices.length - 1]; i >= 0; i--) {
            arr[1][i] = Math.max(arr[1][i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int res = Math.max(0, arr[1][0]);

        for (int i = 0; i + 1 < prices.length; i++)
            res = Math.max(res, arr[0][i] + arr[1][i + 1]);

        return res;
    }
}
