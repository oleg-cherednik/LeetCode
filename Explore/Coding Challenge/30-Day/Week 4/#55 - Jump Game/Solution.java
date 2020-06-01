/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.04.2020
 */

public class Solution {

    public static void main(String... args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));   // true
        System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));   // false
        System.out.println(canJump(new int[] { 0 }));   // true
    }

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--)
            if (i + nums[i] >= lastPos)
                lastPos = i;

        return lastPos == 0;
    }
}
