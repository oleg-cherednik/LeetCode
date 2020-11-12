import java.util.Arrays;

/**
 * Given the array <tt>nums</tt> consisting of <tt>2<sub>n</sub></tt> elements in the form <tt>[x<sub>1</sub>,x<sub>2</sub>,...,x<sub>n</sub>,
 * y<sub>1</sub>,y<sub>2</sub>,...,y<sub>n</sub>]</tt>.
 * <p>
 * <i>Return the array in the form</i> <tt>[x<sub>1</sub>,y<sub>1</sub>,x<sub>2</sub>,y<sub>2</sub>,...,x<sub>n</sub>,y<sub>n</sub>]</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= n <= 500</tt></li>
 * <li><tt>nums.length == 2<sub>n</sub></tt></li>
 * <li><tt>1 <= nums[i] <= 10<sup>3</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));        // [2,3,5,4,1,7]
        System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));  // [1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));              // [1,2,1,2]
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, arr.length);

        for (int i = 0, j = 0, k = n; k < nums.length; ) {
            nums[i++] = arr[j++];
            nums[i++] = arr[k++];
        }

        return nums;
    }
}
