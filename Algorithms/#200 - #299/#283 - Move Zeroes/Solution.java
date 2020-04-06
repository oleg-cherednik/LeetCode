import java.util.Arrays;

/**
 * Given an array <tt>nums</tt>, write a function to move all <tt>0</tt>'s to the end of it while maintaining the relative order of the non-zero
 * elements.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>You must do this in-place without making a copy of the array.</li>
 * <li>Minimize the total number of operations.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 05.04.2019
 */
public class Solution {

    public static void main(String... args) {
        minimizeZeroesAndPrint(0, 1, 0, 3, 12);    // [1, 3, 12, 0, 0]
    }

    private static void minimizeZeroesAndPrint(int... nums) {
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return;

        for (int i = 0, j = 0; i < nums.length; ) {
            if (j >= nums.length)
                nums[i++] = 0;
            else if (i == j) {
                if (nums[j] != 0)
                    i++;

                j++;
            } else {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    i++;
                }

                j++;
            }
        }
    }
}
