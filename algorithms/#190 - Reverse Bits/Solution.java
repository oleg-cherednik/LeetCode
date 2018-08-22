/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * <b>Example:</b>
 * <pre>
 * <b>Input:</b> 43261596
 * <b>Output:</b> 964176192
 * <b>Explanation:</b> 43261596 represented in binary as <b>00000010100101000001111010011100</b>,
 *              return 964176192 represented in binary as <b>00111001011110000010100101000000</b>.
 * </pre>
 * <p>
 * <b>Follow up:</b><br>
 * If this function is called many times, how would you optimize it?
 *
 * @author Oleg Cherednik
 * @since 22.08.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        long val = n & 0x00000000ffffffffL;
        String str = Long.toBinaryString(val);
        str = str.length() < 32 ? String.format("%0" + (32 - str.length()) + "d%s", 0, str) : str;
        return (int)Long.parseLong(new StringBuilder(str).reverse().toString(), 2);
    }

}
