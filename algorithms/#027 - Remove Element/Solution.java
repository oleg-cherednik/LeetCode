/**
 * Given an array <tt>nums</tt> and a value <tt>val</tt>, remove all instances of that value <b>in-place</b> and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by <b>modifying the input array in-place</b> with <tt>O(1)</tt> extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 * </pre>
 * <b>Clarification:</b>
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by <b>reference</b>, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <pre>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 2));    // 2
        System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));    // 5
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int j = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[j++] = nums[i];

        return j;
    }

}
