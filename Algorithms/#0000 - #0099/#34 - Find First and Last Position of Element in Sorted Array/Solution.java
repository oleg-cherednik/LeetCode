import java.util.Arrays;

/**
 * Given an array of integers <tt>nums</tt> sorted in ascending order, find the starting and ending position of a given <tt>target</tt> value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of <tt>O(log n)</tt>.
 * <p>
 * If the target is not found in the array, return <tt>[-1, -1]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= nums.length <= 10<sup>5</sup></tt></li>
 * <li><tt>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></tt></li>
 * <li><tt>nums</tt> is a non decreasing array.</li>
 * <li>-10<sup>9</sup> <= target <= 10<sup>9</sup></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));   // [3, 4]
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));   // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[0], 0)));                        // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[] { 2, 2 }, 2)));                // [0, 1]
        System.out.println(Arrays.toString(searchRange(new int[] { 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4,
                5, 6, 6, 6, 7, 8, 8 }, 4)));                // [10, 12]
    }

    public static int[] searchRange(int[] nums, int target) {
        int pos = findLocation(nums, target);

        if (pos == -1)
            return new int[] { -1, -1 };

        return new int[] { findMin(nums, pos, target), findMax(nums, pos, target) };
    }

    private static int findLocation(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int min = 0;
        int max = nums.length - 1;

        while (true) {
            if (nums[min] == target)
                return min;
            if (nums[max] == target)
                return max;
            if (min + 1 >= max)
                return -1;

            int mid = (min + max) / 2;

            if (nums[mid] == target)
                return mid;

            if (target < nums[mid])
                max = mid;
            else
                min = mid;
        }
    }

    private static int findMin(int[] nums, int max, int target) {
        int min = 0;

        while (min + 1 < max) {
            int mid = (min + max) / 2;

            if (nums[mid] == target)
                max = mid;
            else
                min = mid;
        }

        return nums[min] == target ? min : max;
    }

    private static int findMax(int[] nums, int min, int target) {
        int max = nums.length - 1;

        while (min + 1 < max) {
            int mid = (min + max) / 2;

            if (nums[mid] == target)
                min = mid;
            else
                max = mid;
        }

        return nums[max] == target ? max : min;
    }

}
