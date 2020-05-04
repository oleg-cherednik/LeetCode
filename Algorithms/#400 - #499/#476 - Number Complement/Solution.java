/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The given integer is guaranteed to fit within the range of a 32-bit signed integer.</li>
 * <li>You could assume no leading zero bit in the integer’s binary representation.</li>
 * <li>This question is the same as <a href="https://leetcode.com/problems/complement-of-base-10-integer/">1009. Complement of Base 10 Integer</a></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 04.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findComplement(5));  // 2
        System.out.println(findComplement(1));  // 0
    }

    public static int findComplement(int num) {
        int bit = 30;
        int mask = 0b01111111_11111111_11111111_11111111;

        while ((num & (1 << bit)) == 0 && bit > 0) {
            bit--;
            mask >>= 1;
        }

        return ~num & mask;
    }

}
