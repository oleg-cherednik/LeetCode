/**
 * Count the number of prime numbers less than a non-negative number, <b>n</b>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(countPrimes(10));    // 4
        System.out.println(countPrimes(2));     // 0
    }

    public static int countPrimes(int n) {
        int res = 0;

        for (int i = 2; i < n; i++)
            if (isPrime(i))
                res++;

        return res;
    }

    private static boolean isPrime(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;

        for (int i = 2, sqrt = (int)Math.sqrt(n); i <= sqrt; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
