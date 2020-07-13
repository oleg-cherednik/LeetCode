/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * <b>Input:</b> 00000010100101000001111010011100
 * <b>Output:</b> 00111001011110000010100101000000
 * <b>Explanation:</b> The input binary string <b>00000010100101000001111010011100</b> represents the unsigned integer <tt>43261596</tt>, so return
 * <tt>964176192</tt> which its binary representation is <bb>00111001011110000010100101000000</bb>.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * <b>Input:</b> 11111111111111111111111111111101
 * <b>Output:</b> 10111111111111111111111111111111
 * <b>Explanation:</b> The input binary string <b>11111111111111111111111111111101</b> represents the unsigned integer <tt>4294967293</tt>, so return
 * <tt>3221225471</tt> which its binary representation is <b>10111111111111111111111111111111</b>.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer
 * type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.</li>
 * <li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement">2's complement notation</a>.
 * Therefore, in <b>Example 2</b> above the input represents the signed integer <tt>-3</tt> and the output represents the signed integer <tt>-1073741825</tt>.</li>
 * </ul>
 * <p>
 * <b>Follow up:</b>
 * <br>
 * If this function is called many times, how would you optimize it?
 *
 * @author Oleg Cherednik
 * @since 22.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseBits(0b00000010100101000001111010011100));    // 964176192
        System.out.println(reverseBits(0b11111111111111111111111111111101));    // -1073741825
    }

    public static int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xFF00ff00) >>> 8) | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

}
