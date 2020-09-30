import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array <tt>nums</tt> of <tt>n</tt> integers, are there elements <tt>a</tt>, <tt>b</tt>, <tt>c</tt> in <tt>nums</tt> such that <tt>a + b + c
 * = 0</tt>? Find all unique triplets in the array which gives the <tt>sum</tt> of <tt>zero</tt>.
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

    public static void main(String... args) {
        System.out.println(threeSumAndPrint(-1, 0, 1, 2, -1, -4));  // [[-1,-1,2],[-1,0,1]]
    }

    private static String threeSumAndPrint(int... nums) {
        List<List<Integer>> triplets = threeSum(nums);

        boolean comma1 = false;
        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (List<Integer> triplet : triplets) {
            if (comma1)
                buf.append(',');

            comma1 = true;

            boolean comma2 = false;
            buf.append('[');

            for (int val : triplet) {
                if (comma2)
                    buf.append(',');

                comma2 = true;
                buf.append(val);
            }

            buf.append(']');
        }

        buf.append(']');
        return buf.toString();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2)
            return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else if (nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);

                    while (l < r && tmp.get(1) == nums[l])
                        l++;
                }
            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }

        return res;
    }
}
