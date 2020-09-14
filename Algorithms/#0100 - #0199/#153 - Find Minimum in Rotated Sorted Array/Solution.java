/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., <tt>[0,1,2,4,5,6,7]</tt> might become <tt>[4,5,6,7,0,1,2]</tt>).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [3,4,5,1,2]
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 25.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));       // 1
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 })); // 0
        System.out.println(findMin(new int[] { 1, 2, 3 }));             // 1
    }

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            if (lo + 1 == hi) {
                lo = nums[lo] < nums[hi] ? lo : hi;
                hi = lo;
            } else if (nums[lo] < nums[hi])
                hi = lo;
            else {
                int mi = (lo + hi) / 2;

                if (nums[lo] < nums[mi])
                    lo = mi;
                else
                    hi = mi;
            }
        }

        return nums[lo];
    }
}
