import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where <tt>1 ≤ a[i] ≤ n</tt> (<tt>n</tt> = size of array), some elements appear
 * <b>twice</b> and others appear <b>once</b>.
 * <p>
 * Find all the elements of <tt>[1, n]</tt> inclusive that <b>do not</b> appear in this array.
 * <p>
 * Could you do it without extra space and in <tt>O(n)</tt> runtime? You may assume the returned list does not count as
 * extra space.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));   // [5, 6]
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            num = Math.abs(num);

            if (nums[Math.abs(num - 1)] > 0)
                nums[num - 1] = -nums[num - 1];
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                res.add(i + 1);

        return res;
    }

}
