import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers <tt>nums</tt> and an integer <tt>k</tt>, return <i>the number of <b>unique</b> k-diff pairs in the array</i>.
 * <ul>
 * A <b>k-diff</b> pair is an integer pair <tt>(nums[i], nums[j])</tt>, where the following are true:
 * <li><tt>0 <= i, j < nums.length</tt></li>
 * <li><tt>i != j</tt></li>
 * <li><tt>a <= b</tt></li>
 * <li><tt>b - a == k</tt></li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 10<sup>4</sup></tt></li>
 * <li><tt>-10<sup>7</sup> <= nums[i] <= 10<sup>7</sup></tt></li>
 * <li><tt>0 <= k <= 10<sup>7</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));                  // 2
        System.out.println(findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));                  // 4
        System.out.println(findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));                  // 1
        System.out.println(findPairs(new int[] { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 }, 3));   // 2
        System.out.println(findPairs(new int[] { -1, -2, -3 }, 1));                     // 2
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> unique = new HashSet<>();
        Set<String> pairs = new HashSet<>();

        for (int num : nums) {
            if (unique.contains(num - k))
                pairs.add(num - k + ":" + num);
            unique.add(num);
        }

        return pairs.size();
    }
}
