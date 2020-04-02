import java.util.HashSet;
import java.util.Set;

/**
 * Given a <b>non-empty</b> array of integers, every element appears <i>twice</i> except for one. Find that single one.
 * <p>
 * <b>Note:</b>
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [2,2,1]
 * Output: 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [4,1,2,1,2]
 * Output: 4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(singleNumber(new int[] { 2, 2, 1 }));        // 1
        System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));  // 4
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int sum1 = 0;
        int sum2 = 0;

        for (int num : nums) {
            sum1 += num;

            if (unique.add(num))
                sum2 += 2 * num;
        }

        return sum2 - sum1;
    }
}
