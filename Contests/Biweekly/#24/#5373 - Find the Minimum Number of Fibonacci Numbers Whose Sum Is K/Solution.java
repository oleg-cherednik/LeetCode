/**
 * Given the number <tt>k</tt>, <i>return the minimum number of Fibonacci numbers whose sum is equal to <tt>k</tt></i>, whether a Fibonacci number
 * could be used multiple times.
 * <p>
 * <ul>
 * The Fibonacci numbers are defined as:
 * <li>F<sub>1</sub> = 1</li
 * <li>F<sub>2</sub> = 1</li>
 * <li>F<sub>n</sub> = F<sub>n-1</sub> + F<sub>n-2</sub> , for n > 2.</li>
 * </ul>
 * It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum <tt>k</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: k = 7
 * Output: 2
 * Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
 * For k = 7 we can use 2 + 5 = 7.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: k = 10
 * Output: 2
 * Explanation: For k = 10 we can use 2 + 8 = 10.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: k = 19
 * Output: 3
 * Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMinFibonacciNumbers(7));     // 2
        System.out.println(findMinFibonacciNumbers(10));    // 2
        System.out.println(findMinFibonacciNumbers(19));    // 3
    }

    public static int findMinFibonacciNumbers(int k) {
        return 0;
    }
}
