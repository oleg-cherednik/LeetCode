import java.util.HashMap;
import java.util.Map;

/**
 * <tt>X</tt> is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from <tt>X</tt>.
 * Each
 * digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. <tt>0</tt>, <tt>1</tt>, and <tt>8</tt> rotate to themselves; <tt>2</tt> and
 * <tt>5</tt> rotate to each other (on this case they are rotated in a different direction, in other words <tt>2</tt> or <tt>5</tt> gets mirrored);
 * <tt>6</tt> and <tt>9</tt> rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * <p>
 * Now given a positive number <tt>N</tt>, how many numbers <tt>X</tt> from <tt>1</tt> to <tt>N</tt> are good?
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>N</tt>  will be in range <tt>[1, 10000]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 06.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rotatedDigits(10));  // 4
    }

    public static int rotatedDigits(int N) {
        int res = 0;

        for (int i = 1; i <= N; i++)
            if (isGood(i))
                res++;

        return res;
    }

    private static final Map<Integer, Integer> MAP = new HashMap<>();

    static {
        MAP.put(0, 0);
        MAP.put(1, 1);
        MAP.put(2, 5);
        MAP.put(3, null);
        MAP.put(4, null);
        MAP.put(5, 2);
        MAP.put(6, 9);
        MAP.put(7, null);
        MAP.put(8, 8);
        MAP.put(9, 6);
    }

    private static boolean isGood(final int a) {
        int aa = a;
        int b = 0;
        int p = 0;
        boolean doMore = true;

        do {
            if (aa < 10)
                doMore = false;

            Integer digit = MAP.get(aa % 10);

            if (digit == null)
                return false;

            for (int i = 0; i < p; i++)
                digit *= 10;

            b += digit;
            p++;
            aa /= 10;
        } while (doMore);

        return a != b;
    }

}

