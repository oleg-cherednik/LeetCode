import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a collection of numbers, <tt>nums</tt>, that might contain duplicates, return <i>all possible unique permutations <b>in any order</b></i>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 8</tt></li>
 * <li><tt>-10 <= nums[i] <= 10</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 12.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(permuteUniqueToString(1, 1, 2));   // [[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(permuteUniqueToString(1, 2, 3));   // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }

    private static String permuteUniqueToString(int... nums) {
        List<List<Integer>> res = permuteUnique(nums);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (List<Integer> row : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(row.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
        }

        buf.append(']');
        return buf.toString();
    }

    public static List<List<Integer>> permuteUnique(int... nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        Arrays.sort(nums);
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        permuteUnique(map, nums, -1);
        return new ArrayList<>(map.values());
    }

    private static void permuteUnique(Map<String, List<Integer>> map, int[] nums, int j) {
        j++;

        if (j == nums.length - 1) {
            List<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
            String key = res.stream().map(String::valueOf).collect(Collectors.joining(","));
            map.putIfAbsent(key, res);
        } else {
            for (int i = j; i < nums.length; i++) {
                swap(nums, j, i);
                permuteUnique(map, nums, j);
                swap(nums, j, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
