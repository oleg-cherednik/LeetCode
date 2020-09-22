import java.util.Arrays;
import java.util.Random;

/**
 * Given the <b>API</b> <tt>rand7()</tt> that generates a uniform random integer in the range <tt>[1, 7]</tt>, write a function <tt>rand10()</tt>
 * that generates a uniform random integer in the range <tt>[1, 10]</tt>. You can only call the API <tt>rand7()</tt>, and you shouldn't call any
 * other API. Please <b>do not</b> use a language's built-in random API.
 * <p>
 * Each test case will have one <b>internal</b> argument <tt>n</tt>, the number of times that your implemented function <tt>rand10()</tt> will be
 * called while testing. Note that this is <b>not an argument</b> passed to rand10().
 * <ul>
 * <b>Follow up:</b>
 * <li>What is the <a href="https://en.wikipedia.org/wiki/Expected_value">expected value</a> for the number of calls to <tt>rand7()</tt> function?</li>
 * <li>Could you minimize the number of calls to <tt>rand7()</tt>?</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 1
 * Output: [2]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 2
 * Output: [2,8]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: n = 3
 * Output: [3,8,10]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 10<sup>5</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.09.2020
 */
public class Solution extends SolBase {

    public static void main(String... args) {
        System.out.println(Arrays.toString(rand10(1)));  // [4]
        System.out.println(Arrays.toString(rand10(2)));  // [8, 6]
        System.out.println(Arrays.toString(rand10(3)));  // [8, 5, 8]
    }

    private static int[] rand10(int n) {
        Solution solution = new Solution();
        int[] res = new int[n];

        for (int i = 0; i < res.length; i++)
            res[i] = solution.rand10();

        return res;
    }

    public int rand10() {
        while (true) {
            int cur = 7 * (rand7() - 1) + rand7();

            if (cur <= 40)
                return 1 + (cur - 1) % 10;
        }
    }

}

class SolBase {

    private final Random random = new Random();

    public int rand7() {
        return random.nextInt(8);
    }
}
