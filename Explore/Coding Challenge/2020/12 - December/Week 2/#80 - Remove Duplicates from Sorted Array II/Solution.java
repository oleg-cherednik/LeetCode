import java.util.Arrays;

/**
 * Given a sorted array <tt>nums</tt>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm"><b>in-place</b></a> such that
 * duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array; you must do this by <b>modifying the input array</b> <a
 * href="https://en.wikipedia.org/wiki/In-place_algorithm"><b>in-place</b></a> with <tt>O(1)</tt> extra memory.
 * <p>
 * <b>Clarification:</b>
 * <p>
 * Confused why the returned value is an integer, but your answer is an array?
 * <p>
 * Note that the input array is passed in by <b>reference</b>, which means a modification to the input array will be known to the caller.
 * <p>
 * Internally you can think of this:
 * <pre>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * </pre>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter
 * what you leave beyond the returned length.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3]
 * Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>0 <= nums.length <= 3 * 10<sup>4</sup></tt></li>
 * <li><tt>-104 <= nums[i] <= 10<sup>4</sup></tt></li>
 * <li><tt>nums</tt> is sorted in ascending order.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(removeDuplicatesImpl(1, 1, 1, 2, 2, 3)));           // [1, 1, 2, 2, 3]
        System.out.println(Arrays.toString(removeDuplicatesImpl(0, 0, 1, 1, 1, 1, 2, 3, 3)));  // [0, 0, 1, 1, 2, 3, 3]
    }

    private static int[] removeDuplicatesImpl(int... nums) {
        int total = removeDuplicates(nums);
        int[] arr = new int[total];
        System.arraycopy(nums, 0, arr, 0, arr.length);
        return arr;
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;

        for (int i = 1, count = 1; i < nums.length; i++)
            if ((count = nums[i - 1] == nums[i] ? count + 1 : 1) <= 2)
                nums[j++] = nums[i];

        return j;
    }
}
