/**
 * Given an integer array <tt>nums</tt>, return <t>the <b>third distinct
 * maximum</b> number in this array. If the third maximum does not exist, return
 * the <b>maximum</b> number</t>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * </pre>
 * <ul>
 * Constraints:
 * <li><tt>1 <= nums.length <= 10<sup>4</sup></tt></li>
 * <li><tt>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup>-1</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.06.2025
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(thirdMax(new int[] { 3, 2, 1 }));    // 1
        System.out.println(thirdMax(new int[] { 1, 2 }));       // 2
        System.out.println(thirdMax(new int[] { 2, 2, 3, 1 })); // 1
        System.out.println(thirdMax(new int[] { 1, 2147483647, -2147483648 })); // -2147483648
    }

    public static int thirdMax(int[] nums) {
        int firstMax = max(nums, Long.MAX_VALUE);
        Integer secondMax = max(nums, firstMax);
        Integer thirdMax = secondMax == null ? null : max(nums, secondMax);
        return thirdMax == null ? firstMax : thirdMax;
    }

    private static Integer max(int[] nums, long prvMax) {
        Integer max = null;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < prvMax)
                max = max == null ? nums[i] : Math.max(max, nums[i]);

        return max;
    }

}
