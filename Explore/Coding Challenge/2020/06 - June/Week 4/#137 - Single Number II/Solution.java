/**
 * Given a <b>non-empty</b> array of integers, every element appears <i>three</i> times except for one, which appears exactly once. Find that single
 * one.
 * <p>
 * <b>Note:</b>
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [2,2,3,2]
 * Output: 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));                             // 3
        System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));                   // 99
        System.out.println(singleNumber(new int[] { -2, -2, 1, 1, -3, 1, -3, -3, -4, -2 }));    // -4
    }

    public static int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        int three;

        for (int num : nums) {
            two |= num & one;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }

        return one;
    }
}
