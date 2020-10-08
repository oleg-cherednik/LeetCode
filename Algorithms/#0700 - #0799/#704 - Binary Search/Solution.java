/**
 * Given a <b>sorted</b> (in ascending order) integer array <tt>nums</tt> of <tt>n</tt> elements and a <tt>target</tt> value, write a function to
 * search <tt>target</tt> in <tt>nums</tt>. If <tt>target</tt> exists, then return its index, otherwise return <tt>-1</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>You may assume that all elements in <tt>nums</tt> are unique.</li>
 * <li><tt>n</tt> will be in the range <tt>[1, 10000]</tt>.</li>
 * <li>The value of each element in <tt>nums</tt> will be in the range <tt>[-9999, 9999]</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 08.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));    // 4
        System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));    // -1
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return nums[left] == target ? left : -1;
    }

}
