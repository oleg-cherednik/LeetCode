import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of <b>distinct</b> positive integers, find the largest subset such that every pair <tt>(Si, Sj)</tt> of elements in this subset
 * satisfies:
 * <p>
 * <tt>Si % Sj = 0 or Sj % Si = 0</tt>.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 14.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(largestDivisibleSubset(new int[] { 1, 2, 3 }));      // [1, 2]
        System.out.println(largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));   // [1, 2, 4, 8]
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];

        Arrays.sort(nums);

        int max = 0;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();

        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }

        res.sort(Comparator.naturalOrder());

        return res;
    }
}
