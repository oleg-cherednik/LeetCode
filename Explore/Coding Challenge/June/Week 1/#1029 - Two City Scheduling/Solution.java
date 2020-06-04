import java.util.Arrays;

/**
 * There are <tt>2N</tt> people a company is planning to interview. The cost of flying the <tt>i-th</tt> person to city <tt>A</tt> is
 * <tt>costs[i][0]</tt>, and the cost of flying the <tt>i-th</tt> person to city <tt>B</tt> is <tt>costs[i][1]</tt>.
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly <tt>N</tt> people arrive in each city.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= costs.length <= 100</tt></li>
 * <li>It is guaranteed that <tt>costs.length</tt> is even.</li>
 * <li><tt>1 <= costs[i][0], costs[i][1] <= 1000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 04.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(twoCitySchedCost(new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } })); // 110
    }

    public static int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int[] refund = new int[costs.length];

        for (int i = 0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
            res += costs[i][0];
        }

        Arrays.sort(refund);

        for (int i = 0; i < costs.length / 2; i++)
            res += refund[i];

        return res;
    }
}
