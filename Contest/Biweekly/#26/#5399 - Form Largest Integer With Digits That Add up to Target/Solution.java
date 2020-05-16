import java.math.BigInteger;
import java.util.Arrays;

/**
 * <ul>
 * Given an array of integers <tt>cost</tt> and an integer <tt>target</tt>. Return the <b>maximum</b> integer you can paint under the following rules:
 * <li>The cost of painting a digit (i+1) is given by <tt>cost[i]</tt> (0 indexed).</li>
 * <li>The total cost used must be equal to <tt>target</tt>.</li>
 * <li>Integer does not have digits 0.</li>
 * </ul>
 * Since the answer may be too large, return it as string.
 * <p>
 * If there is no way to paint any integer given the condition, return "0".
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
 * Output: "7772"
 * Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "997", but
 * "7772" is the largest number.
 * Digit    cost
 *   1  ->   4
 *   2  ->   3
 *   3  ->   2
 *   4  ->   5
 *   5  ->   6
 *   6  ->   7
 *   7  ->   2
 *   8  ->   5
 *   9  ->   5
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
 * Output: "85"
 * Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
 * Output: "0"
 * Explanation: It's not possible to paint any integer with total cost equal to target.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
 * Output: "32211"
 * </?pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>cost.length == 9</tt></li>
 * <li><tt>1 <= cost[i] <= 5000</tt></li>
 * <li><tt>1 <= target <= 5000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestNumber(new int[] { 4, 3, 2, 5, 6, 7, 2, 5, 5 }, 9));          // 7772
        System.out.println(largestNumber(new int[] { 7, 6, 5, 5, 5, 6, 8, 7, 8 }, 12));         // 85
        System.out.println(largestNumber(new int[] { 2, 4, 6, 2, 4, 6, 4, 4, 4 }, 5));          // 0
        System.out.println(largestNumber(new int[] { 6, 10, 15, 40, 40, 40, 40, 40, 40 }, 47)); // 32211
        System.out.println(largestNumber(new int[] { 2, 4, 2, 5, 3, 2, 5, 5, 4 }, 739));
    }

    public static String largestNumber(int[] cost, int target) {
        BigInteger[] dp = new BigInteger[target + 1];
        Arrays.fill(dp, BigInteger.valueOf(-1));
        dp[0] = BigInteger.ZERO;

        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < 9; j++) {
                if (i - cost[j] >= 0 && dp[i - cost[j]].compareTo(BigInteger.ZERO) >= 0) {
                    BigInteger one = dp[i - cost[j]].multiply(BigInteger.TEN).add(BigInteger.valueOf(j)).add(BigInteger.ONE);
                    dp[i] = one.compareTo(dp[i]) >= 0 ? one : dp[i];
                }
            }
        }

        return String.valueOf(dp[target].compareTo(BigInteger.ZERO) > 0 ? dp[target] : BigInteger.ZERO);
    }

}
