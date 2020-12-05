/**
 * Given two positive integers <tt>n</tt> and <tt>k</tt>.
 * <p>
 * A factor of an integer <tt>n</tt> is defined as an integer <tt>i</tt> where <tt>n % i == 0</tt>.
 * <p>
 * Consider a list of all factors of <tt>n</tt> sorted in <b>ascending order</b>, return <i>the <tt>k<sup>th</sup></tt> factor</i> in this list or
 * return <b>-1</b> if <tt>n</tt> has less than <tt>k</tt> factors.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 12, k = 3
 * Output: 3
 * Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 7, k = 2
 * Output: 7
 * Explanation: Factors list is [1, 7], the 2nd factor is 7.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 4, k = 4
 * Output: -1
 * Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: n = 1, k = 1
 * Output: 1
 * Explanation: Factors list is [1], the 1st factor is 1.
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: n = 1000, k = 3
 * Output: 4
 * Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000].
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>1 <= k <= n <= 1000</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 27.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kthFactor(12, 3));   // 3
        System.out.println(kthFactor(7, 2));    // 7
        System.out.println(kthFactor(4, 4));    // -1
        System.out.println(kthFactor(1, 1));    // 1
        System.out.println(kthFactor(1000, 3)); // 4
    }

    public static int kthFactor(int n, int k) {
        for (int i = 1, j = 1; i <= n; i++) {
            if (n % i != 0)
                continue;

            if (j < k)
                j++;
            else
                return i;
        }

        return -1;
    }

}
