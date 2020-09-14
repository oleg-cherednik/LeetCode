/**
 * Given a range <tt>[m, n]</tt> where <tt>0 <= m <= n <= 2147483647</tt>, return the <tt>bitwise AND</tt> of all numbers in this range, inclusive.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [5,7]
 * Output: 4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [0,1]
 * Output: 0
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rangeBitwiseAnd(5, 7));                      // 4
        System.out.println(rangeBitwiseAnd(0, 1));                      // 0
        System.out.println(rangeBitwiseAnd(0, 2147483647));             // 0
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));    // 0
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int res = m;

        for (; m >= 0 && m <= n && res != 0; m++)
            res &= m;

        return res;
    }

}
