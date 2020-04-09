/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in
 * order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,3,5,6], 5
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,3,5,6], 2
 * Output: 1
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [1,3,5,6], 7
 * Output: 4
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: [1,3,5,6], 0
 * Output: 0
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));  // 2
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6, 7 }, 2));  // 1
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));  // 4
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));  // 0
    }

    public static int searchInsert(int[] nums, int target) {
        if (target <= nums[0])
            return 0;
        if (nums[nums.length - 1] == target)
            return nums.length - 1;
        if (nums[nums.length - 1] < target)
            return nums.length;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int i, int j, int target) {
        int mid = (i + j) / 2;

        if (mid == i)
            return target <= nums[i] ? i : j;
        if (target == nums[mid])
            return mid;
        if (target < nums[mid])
            return binarySearch(nums, i, mid, target);
        return binarySearch(nums, mid, j, target);
    }

}
