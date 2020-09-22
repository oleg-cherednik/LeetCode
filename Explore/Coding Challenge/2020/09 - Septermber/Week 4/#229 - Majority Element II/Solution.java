import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array of size <tt>n</tt>, find all elements that appear more than <tt>⌊ n/3 ⌋</tt> times.
 * <p>
 * <b>Note:</b> The algorithm should run in linear time and in <tt>O(1)</tt> space.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [3,2,3]
 * Output: [3]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(majorityElement(new int[] { 3, 2, 3 }));                 // [3]
        System.out.println(majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));  // [1, 2]
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        List<Integer> res = new ArrayList<>(2);
        double threshold = nums.length / 3.;

        if (Double.compare(count1, threshold) > 0)
            res.add(candidate1);
        if (Double.compare(count2, threshold) > 0)
            res.add(candidate2);

        return res;
    }
}
