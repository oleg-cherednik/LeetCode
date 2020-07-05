/**
 * The <a herf="https://en.wikipedia.org/wiki/Hamming_distance">Hamming distance</a> between two integers is the number of positions at which the
 * corresponding bits are different.
 * <p>
 * Given two integers <tt>x</tt> and <tt>y</tt>, calculate the Hamming distance.
 * <p>
 * <b>Note:</b>
 * <p>
 * <tt>0 ≤ x, y < 2<sup>31</sup></tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 05.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hammingDistance(1, 4));  // 2
    }

    private static final int G31 = 0b0100_1001_0010_0100_1001_0010_0100_1001;
    private static final int G32 = 0b0011_1000_0001_1100_0000_1110_0000_0111;

    public static int hammingDistance(int x, int y) {
        int val = x ^ y;
        val = (val & G31) + ((val >> 1) & G31) + ((val >> 2) & G31);
        val = ((val + (val >> 3)) & G32) + ((val >> 6) & G32);
        return (val + (val >> 9) + (val >> 18) + (val >> 27)) & 0x3f;
    }

}
