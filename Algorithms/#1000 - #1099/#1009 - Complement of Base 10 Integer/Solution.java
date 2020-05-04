/**
 * Every non-negative integer <tt>N</tt> has a binary representation. For example, <tt>5</tt> can be represented as <tt>"101"</tt> in binary,
 * <tt>11</tt> as <tt>"1011"</tt> in binary, and so on. Note that except for <tt>N = 0</tt>, there are no leading zeroes in any binary
 * representation.
 * <p>
 * The <i>complement</i> of a binary representation is the number in binary you get when changing every <tt>1</tt> to a <tt>0</tt> and <tt>0</tt> to a
 * <tt>1</tt>. For example, the complement of <tt>"101"</tt> in binary is <tt>"010"</tt> in binary.
 * <p>
 * For a given number <tt>N</tt> in base-10, return the complement of it's binary representation as a base-10 integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>0 <= N < 10<sup>9</sup></tt></li>
 * <li>This question is the same as <a href="https://leetcode.com/problems/number-complement/">476. Number Complement</a></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(bitwiseComplement(0));               // 1
        System.out.println(bitwiseComplement(5));               // 2
        System.out.println(bitwiseComplement(7));               // 0
        System.out.println(bitwiseComplement(10));              // 5
        System.out.println(bitwiseComplement((int)1E9 - 1));    // 73741824
    }

    public static int bitwiseComplement(int N) {
        int bit = 30;
        int mask = 0b01111111_11111111_11111111_11111111;

        while ((N & (1 << bit)) == 0 && bit > 0) {
            bit--;
            mask >>= 1;
        }

        return ~N & mask;
    }

}
