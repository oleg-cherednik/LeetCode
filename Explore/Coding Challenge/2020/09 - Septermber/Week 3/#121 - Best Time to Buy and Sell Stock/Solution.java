/**
 * Say you have an array for which the <tt>i<sup>th</sup></tt> element is the price of a given stock on day <tt>i</tt>.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the
 * maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));  // 5
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return res;
    }
}
