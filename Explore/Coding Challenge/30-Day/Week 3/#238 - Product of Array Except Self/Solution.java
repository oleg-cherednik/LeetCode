import java.util.Arrays;

/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers where <tt>n > 1</tt>, return an array <tt>output</tt> such that <tt>output[i]</tt> is equal to
 * the product of all the elements of <tt>nums</tt> except <tt>nums[i]</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * </pre>
 * <b>Constraint:</b> It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32
 * bit integer.
 * <p>
 * <b>Note:</b> Please solve it without division and in <tt>O(n)</tt>.
 * <p>
 * <b>Follow up:</b><br>
 * Could you solve it with constant space complexity? (The output array <b>does not</b> count as extra space for the purpose of space complexity
 * analysis.)
 *
 * @author Oleg Cherednik
 * @since 15.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));       // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4, 5, 6 }))); // [720, 360, 240, 180, 144, 120]
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1 })));                // [1]
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--)
            res[i] = i + 1 < res.length ? nums[i] * res[i + 1] : nums[i];

        for (int i = 0, left = 1; i < nums.length; left *= nums[i++])
            res[i] = left * (i + 1 < res.length ? res[i + 1] : 1);

        return res;
    }
}
