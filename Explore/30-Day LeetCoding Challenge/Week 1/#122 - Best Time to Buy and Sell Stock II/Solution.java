/**
 * Say you have an array for which the <tt>i<sup>th</sup></tt> element is the price of a given stock on day <tt>i</tt>.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * <p>
 * <b>Note:</b> You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
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
 * @since 05.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProfit(new int[] { 1, 3, 5, 1, 3, 5 }));  // 7
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));  // 7
        System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));     // 4
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));     // 0
        System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));  // 7
        System.out.println(maxProfit(new int[] { 2, 1, 2, 0, 1 }));     // 2
    }

    public static int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];

        return max;
    }
}
