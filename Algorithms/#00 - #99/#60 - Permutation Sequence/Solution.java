import java.util.ArrayList;
import java.util.List;

/**
 * The set <tt>[1,2,3,...,n]</tt> contains a total of <tt>n!</tt> unique permutations.
 * <ol>
 * By listing and labeling all of the permutations in order, we get the following sequence for <tt>n = 3</tt>:
 * <p>
 * <li>"123"</li>
 * <li>"132"</li>
 * <li>"213"</li>
 * <li>"231"</li>
 * <li>"312"</li>
 * <li>"321"</li>
 * </ol>
 * Given <tt>n</tt> and <tt>k</tt>, return the <tt>k<sup>th</sup></tt> permutation sequence.
 * <ul>
 * <b>Note:</b>
 * <li>Given n will be between <tt>1</tt> and <tt>9</tt> inclusive.</li>
 * <li>Given k will be between <tt>1</tt> and <tt>n!</tt> inclusive.</li>
 * </ul>
 * <b>Example 1:</b>
 * <pre>
 * Input: n = 3, k = 3
 * Output: "213"
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: n = 4, k = 9
 * Output: "2314"
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 21.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getPermutation(3, 3));   // 213
        System.out.println(getPermutation(4, 9));   // 2314
    }

    public static String getPermutation(int n, int k) {
        int[] fact = new int[n];
        List<Integer> nums = new ArrayList<>(n);

        for (int i = 0; i < n; fact[i] = i == 0 ? 1 : i * fact[i - 1], i++)
            nums.add(i + 1);

        k--;
        StringBuilder buf = new StringBuilder();

        for (int i = n - 1; i >= 0; k %= fact[i], i--)
            buf.append(nums.remove((int)(k / fact[i])));

        return buf.toString();
    }

}
