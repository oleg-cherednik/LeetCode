import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of
 * its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 19
 * Output: true
 * Explanation:
 * 1<sup>2</sup> + 9<sup>2</sup> = 82
 * 8<sup>2</sup> + 2<sup>2</sup> = 68
 * 6<sup>2</sup> + 8<sup>2</sup> = 100
 * 1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isHappy(19));    // true
    }

    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while (true) {
            int sum = 0;

            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            if (sum == 1)
                return true;
            if (!visited.add(sum))
                return false;

            n = sum;
        }
    }
}
