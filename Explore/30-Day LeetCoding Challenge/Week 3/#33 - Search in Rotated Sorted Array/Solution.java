/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., <tt>[0,1,2,4,5,6,7]</tt> might become <tt>[4,5,6,7,0,1,2]</tt>).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return <tt>-1</tt>.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of <tt>O(log n)</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 19.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));   // 4
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));   // -1
        System.out.println(search(new int[] { 5, 1, 3 }, 1));               // 1
        System.out.println(search(new int[] { 1, 3 }, 0));                  // -1
        System.out.println(search(new int[] { 5, 1, 3 }, 5));               // 0
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int i, int j) {
        if (j == -1)
            return -1;
        if (i == j)
            return nums[i] == target ? i : -1;
        if (i + 1 == j) {
            if (nums[i] == target)
                return i;
            if (nums[j] == target)
                return j;
            return -1;
        }

        int mid = (i + j) / 2;

        if (nums[i] <= nums[mid]) {
            if (target >= nums[i] && target <= nums[mid])
                return search(nums, target, i, mid);
            return search(nums, target, mid, j);
        }
        if (target >= nums[i] || target <= nums[mid])
            return search(nums, target, i, mid);
        if (target >= nums[mid] || target <= nums[j])
            return search(nums, target, mid, j);

        return -1;
    }
}
