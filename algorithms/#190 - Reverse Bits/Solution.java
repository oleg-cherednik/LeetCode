/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.08.2018
 */
public class Solution {

    public int reverseBits(int n) {
        long val = n & 0x00000000ffffffffL;
        String str = Long.toBinaryString(val);
        str = str.length() < 32 ? String.format("%0" + (32 - str.length()) + "d%s", 0, str) : str;
        return (int)Long.parseLong(new StringBuilder(str).reverse().toString(), 2);
    }

}
