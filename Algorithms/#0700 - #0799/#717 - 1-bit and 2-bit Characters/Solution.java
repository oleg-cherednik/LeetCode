/**
 * We have two special characters. The first character can be represented by one bit <tt>0</tt>. The second character can be represented by two bits
 * (<tt>10</tt> or <tt>11</tt>).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always
 * end with a zero.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>1 <= len(bits) <= 1000</tt></li>
 * <li><tt>bits[i]</tt> is always <tt>0</tt> or <tt>1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isOneBitCharacter(new int[] { 1, 0, 0 }));       // true
        System.out.println(isOneBitCharacter(new int[] { 1, 1, 1, 0 }));    // false
    }

    public static boolean isOneBitCharacter(int[] bits) {
        return isOneBitCharacter(bits, 0);
    }

    private static boolean isOneBitCharacter(int[] bits, int i) {
        if (i >= bits.length)
            return false;

        boolean zero = bits[i] == 0;

        if (i == bits.length - 1)
            return zero;
        if (zero)
            return isOneBitCharacter(bits, i + 1);
        return isOneBitCharacter(bits, i + 2);
    }

}
