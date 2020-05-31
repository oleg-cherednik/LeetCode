import java.util.Arrays;

/**
 * Given the array of integers <tt>nums</tt>, you will choose two different indices <tt>i</tt> and <tt>j</tt> of that array. Return the maximum value
 * of <tt>(nums[i]-1)*(nums[j]-1)</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) =
 * (4-1)*(5-1) = 3*4 = 12.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [3,7]
 * Output: 12
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= nums.length <= 500</tt></li>
 * <li><tt>1 <= nums[i] <= 10<sup>3</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 31.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxProduct(new int[] { 3, 4, 5, 2 }));   // 12
        System.out.println(maxProduct(new int[] { 1, 5, 4, 5 }));   // 16
        System.out.println(maxProduct(new int[] { 3, 7 }));         // 12
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

}
