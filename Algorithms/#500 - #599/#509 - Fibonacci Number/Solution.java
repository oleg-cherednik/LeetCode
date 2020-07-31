/**
 * The <b>Fibonacci numbers</b>, commonly denoted <tt>F(n)</tt> form a sequence, called the <b>Fibonacci sequence</b>,
 * such that each number is the sum of the two preceding ones, starting from <tt>0</tt> and <tt>1</tt>. That is,
 * <pre>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * </pre>
 * Given <tt>N</tt>, calculate <tt>F(N)</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * </pre>
 * <b>Note:</b>
 * <p>
 * <tt>0 ≤ N ≤ 30</tt>.
 *
 * @author Oleg Cherednik
 * @since 31.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fib(0));     // 0
        System.out.println(fib(1));     // 1
        System.out.println(fib(2));     // 1
        System.out.println(fib(3));     // 2
        System.out.println(fib(4));     // 3
        System.out.println(fib(30));    // 832040
    }

    public static int fib(int N) {
        final double sqrtFive = 2.23606797749979;
        double a = Math.pow((1 + sqrtFive) / 2., N);
        double b = Math.pow((1 - sqrtFive) / 2., N);
        return (int)((a - b) / sqrtFive);
    }
}
