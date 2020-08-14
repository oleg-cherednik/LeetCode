/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., <tt>[0,1,2,4,5,6,7]</tt> might become <tt>[4,5,6,7,0,1,2]</tt>).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,3,5]
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [2,2,2,0,1]
 * Output: 0
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>This is a follow up problem to <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">Find Minimum in Rotated Sorted Array</a>.</li>
 * <li>Would allow duplicates affect the run-time complexity? How and why?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 25.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMin(new int[] { 1, 3, 5 }));             // 1
        System.out.println(findMin(new int[] { 2, 2, 2, 0, 1 }));       // 0
        System.out.println(findMin(new int[] { 1, 2, 3 }));             // 1
        System.out.println(findMin(new int[] { 10, 1, 10, 10, 10 }));   // 1
    }

    public static int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private static int findMin(int[] nums, int lo, int hi) {
        if (lo == hi || lo + 1 == hi)
            return Math.min(nums[lo], nums[hi]);

        int mi = (lo + hi) / 2;

        if (nums[lo] == nums[hi]) {
            int min = findMin(nums, lo, mi);
            return min < nums[lo] ? min : findMin(nums, mi, hi);
        }

        if (nums[lo] < nums[hi])
            return nums[lo];

        return nums[lo] <= nums[mi] ? findMin(nums, mi, hi) : findMin(nums, lo, mi);
    }
}
