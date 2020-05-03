import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of integers <tt>nums</tt> and an integer <tt>limit</tt>, return the size of the longest continuous subarray such that the absolute
 * difference between any two elements is less than or equal to <tt>limit</tt>.
 * <p>
 * In case there is no subarray satisfying the given condition return 0.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 10<sup>5</sup></tt></li>
 * <li><tt>1 <= nums[i] <= 10<sup>9</sup></tt></li>
 * <li><tt>0 <= limit <= 10<sup>9</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(longestSubarray(new int[] { 8, 2, 4, 7 }, 4));               // 2
        System.out.println(longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5));        // 4
        System.out.println(longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0));   // 3
    }

    public static int longestSubarray(int[] nums, int limit) {
        final Comparator<Integer> sortAbs = Integer::compareUnsigned;
        Queue<Integer> minQueue = new PriorityQueue<>(sortAbs);
        Queue<Integer> maxQueue = new PriorityQueue<>(sortAbs.reversed());
        int res = 0;

        for (int i = 0, j = 0; j < nums.length; ) {
            minQueue.add(nums[j]);
            maxQueue.add(nums[j]);

            int min = minQueue.element();
            int max = maxQueue.element();

            if (Math.abs(min - max) <= limit)
                res = Math.max(res, j - i + 1);
            else {
                minQueue.remove(nums[i]);
                maxQueue.remove(nums[i]);
                i++;
            }
            j++;
        }

        return res;
    }
}
