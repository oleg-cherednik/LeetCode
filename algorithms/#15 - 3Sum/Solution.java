import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers, are there elements <tt>a</tt>, <tt>b</tt>, <tt>c</tt> in <tt>nums</tt> such that <tt>a + b + c
 * = 0</tt>? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * <b>Note:</b><br>
 * The solution set must not contain duplicate triplets.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 22.08.2018
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> uniqueTriplets = new ArrayList<>();

        for (int i = 0, j = i + 1, k = nums.length - 1; i < nums.length - 2; i++, j = i + 1, k = nums.length - 1) {
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);

                    if (!uniqueTriplets.contains(triplet))
                        uniqueTriplets.add(triplet);

                    j++;
                    k--;
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return uniqueTriplets;
    }
}
