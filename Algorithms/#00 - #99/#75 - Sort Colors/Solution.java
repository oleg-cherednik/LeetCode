import java.util.Arrays;

/**
 * Given an array with <tt>n</tt> objects colored red, white or blue, sort them <a href="https://en.wikipedia.org/wiki/In-place_algorithm">in-place</a>
 * so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers <tt>0</tt>, <tt>1</tt>, and <tt>2</tt> to represent the color red, white, and blue respectively.
 * <p>
 * <b>Note:</b> You are not suppose to use the library's sort function for this problem.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * </pre>
 * <ul>
 * <b>Follow up:</b>
 * <li>A rather straight forward solution is a two-pass algorithm using counting sort.<br>
 * First, iterate the array counting number of <tt>0's</tt>, <tt>1's</tt>, and <tt>2's</tt>, then overwrite array with total number of <tt>0's</tt>,
 * then <tt>1's</tt> and followed by <tt>2's</tt>.</li>
 * <li>Could you come up with a one-pass algorithm using only constant space?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 11.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(sorColors(2, 0, 2, 1, 1, 0)));       // [0, 0, 1, 1, 2, 2]
        System.out.println(Arrays.toString(sorColors(0, 1, 2, 1, 2, 1, 0, 0))); // [0, 0, 0, 1, 1, 1, 2, 2]
        System.out.println(Arrays.toString(sorColors(1, 2)));                   // [1, 2]
    }

    private static int[] sorColors(int... nums) {
        sortColors(nums);
        return nums;
    }

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void sortColors(int[] nums) {
        int w = nums.length - 1;
        int b = nums.length - 1;

        for (int i = 0; i <= w; ) {
            if (nums[i] == RED)
                i++;
            else if (nums[i] == WHITE)
                swap(nums, i, w--);
            else if (nums[i] == BLUE) {
                if (w != b) {
                    swap(nums, i, w);
                    swap(nums, w--, b--);
                } else {
                    swap(nums, i, b--);
                    w--;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
