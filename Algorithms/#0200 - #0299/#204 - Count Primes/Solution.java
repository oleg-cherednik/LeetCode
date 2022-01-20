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
        System.out.println(countPrimes(0));         // 0
        System.out.println(countPrimes(1));         // 0
        System.out.println(countPrimes(2));         // 0
        System.out.println(countPrimes(3));         // 1
        System.out.println(countPrimes(10));        // 4
        System.out.println(countPrimes(1_500_000)); // 114155
        System.out.println(countPrimes(5_000_000)); // 348514
    }

    public static int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] notPrimes = new boolean[n];
        int res = n / 2;

        for (int i = 3; i * i < n; i += 2) {
            if (notPrimes[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (notPrimes[j])
                    continue;

                notPrimes[j] = true;
                res--;
            }
        }

        return res;
    }

}
