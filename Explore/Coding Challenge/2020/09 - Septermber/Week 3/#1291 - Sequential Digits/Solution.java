import java.util.ArrayList;
import java.util.List;

/**
 * An integer has <i>sequential digits</i> if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a <b>sorted</b> list of all the integers in the range <tt>[low, high]</tt> inclusive that have sequential digits.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>10 <= low <= high <= 10<sup>9</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(sequentialDigits(100, 300));     // [123, 234]
        System.out.println(sequentialDigits(1000, 13000));  // [1234, 2345, 3456, 4567, 5678, 6789, 12345]
        System.out.println(sequentialDigits(58, 155));      // [67, 78, 89, 123]
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        for (int i = minLen; i <= maxLen; i++) {
            int num = 0;

            for (int j = 1; j <= i; j++)
                num = num * 10 + j;

            if (num >= low && num <= high)
                res.add(num);

            for (int j = i + 1; j < 10 && num <= high; j++) {
                num = (num % (int)Math.pow(10, i - 1)) * 10 + j;

                if (num >= low && num <= high)
                    res.add(num);
            }
        }

        return res;
    }

}
