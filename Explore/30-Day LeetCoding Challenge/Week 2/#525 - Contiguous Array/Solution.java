import java.util.Arrays;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of <tt>0</tt> and <tt>1</tt>.
 * <p>
 * <b>Example 1:</b>
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * </pre>
 * <b>Example 2:</b>
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * </pre>
 * <bNote:</b> The length of the given binary array will not exceed <tt>50,000</tt>.
 *
 * @author Oleg Cherednik
 * @since 14.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMaxLength(new int[] { 0, 1 }));      // 2
        System.out.println(findMaxLength(new int[] { 0, 1, 0 }));   // 2
    }

    public static int findMaxLength(int[] nums) {
        final int NULL = -2;
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, NULL);

        int max = 0;
        final int mid = arr.length / 2;
        arr[mid] = -1;

        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            int m = mid + sum;

            if (arr[m] == NULL)
                arr[m] = i;
            else
                max = Math.max(max, i - arr[m]);
        }

        return max;
    }
}
