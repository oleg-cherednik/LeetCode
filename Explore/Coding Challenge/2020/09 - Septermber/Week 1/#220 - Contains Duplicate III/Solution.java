/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the <b>absolute</b> difference between
 * <b>nums[i]</b> and <b>nums[j]</b> is at most <tt>t</tt> and the <b>absolute</b> difference between <b>i</b> and <b>j</b> is at most <tt>k</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));              // true
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));              // true
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));        // false
        System.out.println(containsNearbyAlmostDuplicate(new int[] { 2, 2 }, 3, 0));                    // true
        System.out.println(containsNearbyAlmostDuplicate(new int[] { -1, 2147483647 }, 1, 2147483647)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i + 1 < nums.length; i++)
            for (int j = i + 1; j < nums.length && j <= i + k; j++)
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t)
                    return true;

        return false;
    }
}
