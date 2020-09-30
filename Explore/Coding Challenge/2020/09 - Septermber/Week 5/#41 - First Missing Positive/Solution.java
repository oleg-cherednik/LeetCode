/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,0]
 * Output: 3
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [3,4,-1,1]
 * Output: 2
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: [7,8,9,11,12]
 * Output: 1
 * </pre>
 * <b>Follow up:</b><br>
 * Your algorithm should run in <tt>O(n)</tt> time and uses constant extra space.
 *
 * @author Oleg Cherednik
 * @since 30.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));                        // 3
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));                    // 2
        System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));                // 1
        System.out.println(firstMissingPositive(new int[] { -3, 4, -2, 0, 6, 2, 3, 1, 7 }));    // 5
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        if (nums.length == 1)
            return getFirstMissing(nums);

        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= 0)
                i++;
            else if (nums[i] - 1 >= nums.length)
                i++;
            else if (nums[i] - 1 == i || nums[nums[i] - 1] == nums[i])
                i++;
            else
                swap(nums, i, nums[i] - 1);
        }

        return getFirstMissing(nums);
    }

    private static int getFirstMissing(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return nums[nums.length - 1] + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
