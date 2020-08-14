/**
 * Given an array <tt>nums</tt> containing <tt>n + 1</tt> integers where each integer is between <tt>1</tt> and <tt>n</tt> (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,3,4,2,2]
 * Output: 2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [3,1,3,4,2]
 * Output: 3
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>You <b>must not</b> modify the array (assume the array is read only).</li>
 * <li>You must use only constant, <tt>O(1)</tt> extra space.</li>
 * <li>Your runtime complexity should be less than <tt>O(n<sup>2</sup>)</tt>.</li>
 * <li>There is only one duplicate number in the array, but it could be repeated more than once.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 25.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));     // 2
        System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));     // 3
        System.out.println(findDuplicate(new int[] { 3, 1, 3, 3, 4, 2 }));  // 3
    }

    public static int findDuplicate(int[] nums) {
        int tort = nums[0];
        int hare = nums[0];

        do {
            tort = nums[tort];
            hare = nums[nums[hare]];
        } while (tort != hare);

        tort = nums[0];

        while (tort != hare) {
            tort = nums[tort];
            hare = nums[hare];
        }

        return hare;
    }

}
