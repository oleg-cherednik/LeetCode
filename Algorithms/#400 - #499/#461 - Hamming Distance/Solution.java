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

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
