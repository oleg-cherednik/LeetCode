import java.util.Deque;
import java.util.LinkedList;

/**
 * The Tribonacci sequence <tt>T<sub>n</sub></tt> is defined as follows:
 * <pre>
 * T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n >= 0.
 * </pre>
 * <p>
 * Given <tt>n</tt>, return the value of <tt>T<sub>n</sub></tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T<sub>3</sub> = 0 + 1 + 1 = 2
 * T<sub>4</sub> = 1 + 1 + 2 = 4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 25
 * Output: 1389537
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>0 <= n <= 37</li>
 * <li>The answer is guaranteed to fit within a 32-bit integer, ie. <tt>answer <= 2<sup>31</sup> - 1</tt>.</li>
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 31.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(tribonacci(0));     // 0
        System.out.println(tribonacci(1));     // 1
        System.out.println(tribonacci(2));     // 1
        System.out.println(tribonacci(3));     // 2
        System.out.println(tribonacci(4));     // 4
        System.out.println(tribonacci(25));    // 1389537
        System.out.println(tribonacci(30));    // 29249425
    }

    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);
        queue.add(1);

        for (int i = 3, sum = 2; i <= n; i++, sum += sum - queue.remove())
            queue.add(sum);

        return queue.getLast();
    }

}
