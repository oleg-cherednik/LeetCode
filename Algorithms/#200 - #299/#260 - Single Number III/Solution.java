import java.util.Arrays;

/**
 * Given an array of numbers <tt>nums</tt>, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the
 * two elements that appear only once.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>The order of the result is not important. So in the above example, <tt>[5, 3]</tt> is also correct.</li>
 * <li>Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 23.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));  // [3, 5]
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums)
            xor ^= num;

        xor &= -xor;

        int[] res = { 0, 0 };

        for (int num : nums)
            res[(num & xor) == 0 ? 1 : 0] ^= num;

        return res;
    }

}
