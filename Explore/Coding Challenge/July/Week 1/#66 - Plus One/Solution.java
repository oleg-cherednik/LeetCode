import java.math.BigInteger;
import java.util.Arrays;

/**
 * Given a <b>non-empty</b> array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));    // [1, 2, 4]
        System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 }))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(plusOne(new int[] { 9 })));          // [1, 0]
        System.out.println(Arrays.toString(
                plusOne(new int[] { 7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0,
                        6 })));          // [7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7]
    }

    public static int[] plusOne(int[] digits) {
        BigInteger val = BigInteger.ZERO;

        for (int i = 0; i < digits.length; i++)
            val = val.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[i]));

        val = val.add(BigInteger.ONE);
        String str = val.toString();

        digits = str.length() == digits.length ? digits : new int[str.length()];

        for (int i = 0; i < digits.length; i++)
            digits[i] = str.charAt(i) - '0';

        return digits;
    }
}
