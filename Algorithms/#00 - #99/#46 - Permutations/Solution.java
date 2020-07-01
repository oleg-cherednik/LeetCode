import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of <b>distinct</b> integers, return all possible permutations.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 01.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(permuteToString(1));         // [[1]]
        System.out.println(permuteToString(1, 2));      // [[1,2],[2,1]]
        System.out.println(permuteToString(1, 2, 3));   // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }

    private static String permuteToString(int... nums) {
        List<List<Integer>> res = permute(nums);

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

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        Arrays.sort(nums);
        return permute(new ArrayList<>(), nums, -1);
    }

    private static List<List<Integer>> permute(List<List<Integer>> res, int[] nums, int j) {
        j++;

        if (j == nums.length - 1)
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        else {
            for (int i = j; i < nums.length; i++) {
                swap(nums, j, i);
                permute(res, nums, j);
                swap(nums, j, i);
            }
        }

        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
