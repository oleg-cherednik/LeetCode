/**
 * You have a total of <tt>n</tt> coins that you want to form in a staircase shape, where every <tt>k-th</tt> row must have exactly <tt>k</tt> coins.
 * <p>
 * Given <tt>n</tt>, find the total number of <b>full</b> staircase rows that can be formed.
 * <p>
 * <tt>n</tt> is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 01.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(arrangeCoins(5));    // 2
        System.out.println(arrangeCoins(8));    // 3
        System.out.println(arrangeCoins(0));    // 0
        System.out.println(arrangeCoins(10));   // 4
    }

    public static int arrangeCoins(int n) {
        int res = 0;
        int i = 1;

        while (n >= i) {
            res++;
            n -= i;
            i++;
        }

        return res;
    }

}
