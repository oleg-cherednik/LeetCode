/**
 * Given an array <tt>nums</tt> of 0s and 1s and an integer <tt>k</tt>, return <tt>True</tt> if all 1's are at least <tt>k</tt> places away from each
 * other, otherwise return <tt>False</tt>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="sample_1_1791.png" />
 * <pre>
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * Explanation: Each of the 1s are at least 2 places away from each other.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="sample_2_1791.png" />
 * <pre>
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: false
 * Explanation: The second 1 and third 1 are only one apart from each other.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,1,1,1,1], k = 0
 * Output: true
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: nums = [0,1,0,1], k = 1
 * Output: true
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 10^5</tt></li>
 * <li><tt>0 <= k <= nums.length</tt></li>
 * <li><tt>nums[i]</tt> is <tt>0</tt> or <tt>1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2));
        System.out.println(kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        for (int i = 0, pos = -1; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            if (pos != -1 && i - pos - 1 < k)
                return false;
            pos = i;
        }

        for (int i = nums.length - 1, pos = -1; i >= 0; i--) {
            if (nums[i] == 0)
                continue;
            if (pos != -1 && pos - i - 1 < k)
                return false;
            pos = i;
        }

        return true;
    }
}
