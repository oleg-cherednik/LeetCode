import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, <tt>1 ≤ a[i] ≤ n</tt> (<tt>n</tt> = size of array), some elements appear <b>twice</b> and
 * others appear <b>once</b>.
 * <p>
 * Find all the elements that appear <b>twice</b> in this array.
 * <p>
 * Could you do it without extra space and in <tt>O(n)</tt> runtime?
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));   // [2, 3]
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (n < 0)
                n = -n;

            if (nums[n - 1] < 0)
                res.add(n);
            else
                nums[n - 1] = -nums[n - 1];
        }

        return res;
    }

}
