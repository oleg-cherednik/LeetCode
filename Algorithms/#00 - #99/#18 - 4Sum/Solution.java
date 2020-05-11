import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers and an integer <tt>target</tt>, are there elements <tt>a</tt>, <tt>b</tt>, <tt>c</tt>, and
 * <tt>d</tt> in
 * <tt>nums</tt> such that <tt>a + b + c + d = target</tt>? Find all unique quadruplets in the array which gives the sum of <tt>target</tt>.
 * <p>
 * <b>Note:</b>
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fourSumToString(new int[] { 1, 0, -1, 0, -2, 2 }, 0));   // [[1, 0, -1, 0], [1, -1, -2, 2], [0, 0, -2, 2]]
        System.out.println(fourSumToString(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 },
                0));   // [[-2, -1, 0, 3], [-2, 0, 0, 2], [-3, -1, 1, 3], [-3, 0, 1, 2], [-3, 0, 0, 3], [-2, -1, 1, 2], [-1, 0, 0, 1], [-3, -2, 2, 3]]
        System.out.println(fourSumToString(new int[] { -5, 5, 4, -3, 0, 0, 4, -2 }, 4));   // [[-5, 0, 4, 5], [-3, -2, 4, 5]]
    }

    private static List<String> fourSumToString(int[] nums, int target) {
        List<List<Integer>> res = fourSum(nums, target);
        return res.stream().map(sum -> sum.stream().mapToInt(i -> i).toArray()).map(Arrays::toString).collect(Collectors.toList());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];
                        int d = nums[l];

                        if (a + b + c + d == target)
                            map.put(String.format("%s|%s|%s|%s", a, b, c, d), Arrays.asList(a, b, c, d));
                    }
                }
            }
        }

        return new ArrayList<>(map.values());
    }
}
