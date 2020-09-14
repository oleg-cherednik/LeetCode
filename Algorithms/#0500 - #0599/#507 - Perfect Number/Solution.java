import java.util.HashSet;
import java.util.Set;

/**
 * We define the Perfect Number is a <b>positive</b> integer that is equal to the sum of all its <b>positive</b>
 * divisors except itself.
 * <p>
 * Now, given an <b>integer</b> <tt>n</tt>, write a function that returns true when it is a perfect number and false
 * when it is not.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * </pre>
 * <b>Note:</b> The input number <tt>n</tt> will not exceed <tt>100,000,000 (1e8)</tt>.
 *
 * @author Oleg Cherednik
 * @since 17.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkPerfectNumber(28)); // true
        System.out.println(checkPerfectNumber(0));  // false
        System.out.println(checkPerfectNumber(1));  // false
    }

    public static boolean checkPerfectNumber(int num) {
        if (num < 2)
            return false;

        int sum = 1;
        Set<Integer> divisors = new HashSet<>();
        divisors.add(1);

        for (int i = 2, sqrt = (int)Math.sqrt(num); i <= sqrt; i++) {
            if (num % i != 0)
                continue;
            if (divisors.add(i))
                sum += i;
            if (divisors.add(num / i))
                sum += num / i;
        }

        return sum == num;
    }
}
