/**
 * In a country popular for train travel, you have planned some train travelling one year in advance. The days of the year that you will travel is
 * given as an array <tt>days</tt>. Each day is an integer from <tt>1</tt> to <tt>365</tt>.
 * <ul>
 * Train tickets are sold in 3 different ways:
 * <li>a 1-day pass is sold for <tt>costs[0]</tt> dollars;</li>
 * <li>a 7-day pass is sold for <tt>costs[1]</tt> dollars;</li>
 * <li>a 30-day pass is sold for <tt>costs[2]</tt> dollars.</li>
 * </ul>
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4,
 * 5, 6, 7, and 8.
 * <p>
 * Return the minimum number of dollars you need to travel every day in the given list of <tt>days</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= days.length <= 365</tt></li>
 * <li><tt>1 <= days[i] <= 365</tt></li>
 * <li><tt>days</tt> is in strictly increasing order.</li>
 * <li><tt>costs.length == 3</tt></li>
 * <li><tt>1 <= costs[i] <= 1000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 26.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));                        // 11
        System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));    // 17
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        dp[1] = costs[0];

        for (int i = 1, j = 0; i < dp.length; i++) {
            if (days[j] == i) {
                dp[i] = dp[Math.max(i - 1, 0)] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
                j++;
            } else
                dp[i] = dp[i - 1];
        }

        return dp[dp.length - 1];
    }
}
