import java.util.Arrays;

/**
 * Given the array <tt>prices</tt> where <tt>prices[i]</tt> is the price of the <tt>i<sub>th</sub></tt> item in a shop. There is a special discount
 * for items in the shop, if you buy the <tt>i<sub>th</sub></tt> item, then you will receive a discount equivalent to <tt>prices[j]</tt> where
 * <tt>j</tt> is the minimum index such that <tt>j > i and prices[j] <= prices[i]</tt>, otherwise, you will not receive any discount at all.
 * <p>
 * <i>Return an array where the <tt>i<sub>th</sub></tt> element is the final price you will pay for the <tt>i<sub>th</sub></tt> item of the shop
 * considering the special discount.</i>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= prices.length <= 500</tt></li>
 * <li><tt>1 <= prices[i] <= 10<sup>3</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(finalPrices(new int[] { 8, 4, 6, 2, 3 })));  // [4, 2, 4, 2, 3]
        System.out.println(Arrays.toString(finalPrices(new int[] { 1, 2, 3, 4, 5 })));  // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(finalPrices(new int[] { 10, 1, 1, 6 })));    // [9, 0, 1, 6]
    }

    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int discount = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i])
                    continue;

                discount = prices[j];
                break;
            }

            res[i] = Math.max(0, prices[i] - discount);
        }

        return res;
    }
}
