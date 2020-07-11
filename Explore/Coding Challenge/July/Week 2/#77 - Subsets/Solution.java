import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a set of <b>distinct</b> integers, <tt>nums</tt>, return all possible subsets (the power set).
 * <p>
 * <b>Note:</b> The solution set must not contain duplicate subsets.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(subsetsToString(1, 2, 3));   // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }

    public static String subsetsToString(int... nums) {
        List<List<Integer>> res = subsets(nums);

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

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0, total = 1 << nums.length; i < total; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0, m = i; m > 0; j++, m >>= 1)
                if ((m & 1) == 1)
                    subset.add(nums[j]);

            res.add(subset);
        }

        return res;
    }

}
