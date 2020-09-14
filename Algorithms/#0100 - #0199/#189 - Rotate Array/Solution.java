import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by <tt>k</tt> steps, where <tt>k</tt> is non-negative.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * </pre>
 * <b>Note:</b>
 * <ul>
 * <li>Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.</li>
 * <li>Could you do it in-place with <tt>O(1)</tt> extra space?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rotateAndString(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3));  // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(rotateAndString(new int[] { -1, -100, 3, 99 }, 2));      // [3, 99, -1, -100]
    }

    private static String rotateAndString(int[] nums, int k) {
        rotate(nums, k);
        return Arrays.toString(nums);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        for (int i = 0, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
        for (int i = 0, j = k - 1; i < j; i++, j--)
            swap(nums, i, j);
        for (int i = k, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
