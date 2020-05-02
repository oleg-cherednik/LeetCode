/**
 * <ul>
 * You are given an integer <tt>num</tt>. You will apply the following steps exactly <b>two</b> times:
 * <li>Pick a digit <tt>x (0 <= x <= 9)</tt>.</li>
 * <li>Pick another digit <tt>y (0 <= y <= 9)</tt>. The digit <tt>y</tt> can be equal to <tt>x</tt>.</li>
 * <li>Replace all the occurrences of <tt>x</tt> in the decimal representation of <tt>num</tt> by <tt>y</tt>.</li>
 * <li>The new integer <b>cannot</b> have any leading zeros, also the new integer <b>cannot</b> be 0.</li>
 * </ul>
 * Let <tt>a</tt> and <tt>b</tt> be the results of applying the operations to <tt>num</tt> the first and second times, respectively.
 * <p>
 * Return <i>the max difference</i> between <tt>a</tt> and <tt>b</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: num = 555
 * Output: 888
 * Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
 * The second time pick x = 5 and y = 1 and store the new integer in b.
 * We have now a = 999 and b = 111 and max difference = 888
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: num = 9
 * Output: 8
 * Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
 * The second time pick x = 9 and y = 1 and store the new integer in b.
 * We have now a = 9 and b = 1 and max difference = 8
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: num = 123456
 * Output: 820000
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: num = 10000
 * Output: 80000
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: num = 9288
 * Output: 8700
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>1 <= num <= 10<sup>8</sup></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxDiff(555));       // 888
        System.out.println(maxDiff(9));         // 8
        System.out.println(maxDiff(123456));    // 820000
        System.out.println(maxDiff(10000));     // 80000
        System.out.println(maxDiff(9288));      // 8700
        System.out.println(maxDiff(1101057));   // 8808050
    }

    public static int maxDiff(int num) {
        String str = String.valueOf(num);
        int a = num;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '9')
                continue;

            a = Integer.parseInt(str.replace(str.charAt(i), '9'));
            break;
        }

        int b = num;

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(0) != '1') {
                    b = Integer.parseInt(str.replace(str.charAt(0), '1'));
                    break;
                }
            } else {
                if (str.charAt(0) != str.charAt(i) && str.charAt(i) != '0') {
                    b = Integer.parseInt(str.replace(str.charAt(i), '0'));
                    break;
                }

                if (str.charAt(0) == str.charAt(i) && str.charAt(i) != '1') {
                    b = Integer.parseInt(str.replace(str.charAt(i), '1'));
                    break;
                }
            }
        }

        return Math.abs(a - b);
    }
}
