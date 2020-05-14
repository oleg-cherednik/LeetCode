/**
 * Write a function that takes an unsigned integer and return the number of <tt>'1'</tt> bits it has (also known as the <a
 * href="https://en.wikipedia.org/wiki/Hamming_weight">Hamming weight</a>).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and
 * should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.</li>
 * <li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement">2's complement notation</a>.
 * Therefore, in <b>Example 3</b> above the input represents the signed integer <tt>-3</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hammingWeight(0b00000000000000000000000000001011));  // 3
        System.out.println(hammingWeight(0b00000000000000000000000010000000));  // 1
        System.out.println(hammingWeight(0b11111111111111111111111111111101));  // 31
    }

    private static final int G31 = 0x49249249; // 0100_1001_0010_0100_1001_0010_0100_1001
    private static final int G32 = 0x381c0e07; // 0011_1000_0001_1100_0000_1110_0000_0111

    public static int hammingWeight(int n) {
        n = (n & G31) + ((n >>> 1) & G31) + ((n >>> 2) & G31);
        n = ((n + (n >>> 3)) & G32) + ((n >>> 6) & G32);
        return (n + (n >>> 9) + (n >>> 18) + (n >>> 27)) & 0x3f;
    }

}
