import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array <tt>target</tt> and an integer <tt>n</tt>. In each iteration, you will read a number from <tt>xlist = {1,2,3..., n}</tt>.
 * <ul>
 * Build the <tt>target</tt> array using the following operations:
 * <li><b>Push:</b> Read a new element from the beginning <tt>list</tt>, and push it in the array.</li>
 * <li><b>Pop:</b> delete the last element of the array.</li>
 * <li>If the target array is already built, stop reading more elements.</li>
 * </ul>
 * You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to <tt>n</tt> inclusive.
 * <p>
 * Return the operations to build the target array.
 * <p>
 * You are guaranteed that the answer is unique.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: target = [1,2,3], n = 3
 * Output: ["Push","Push","Push"]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: target = [1,2], n = 4
 * Output: ["Push","Push"]
 * Explanation: You only need to read the first 2 numbers and stop.
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: target = [2,3,4], n = 4
 * Output: ["Push","Pop","Push","Push","Push"]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= target.length <= 100</tt></li>
 * <li><tt>1 <= target[i] <= 100</tt></li>
 * <li><tt>1 <= n <= 100</tt></li>
 * <li><tt>target</tt> is strictly increasing.</li>
 *
 * @author Oleg Cherednik
 * @since 10.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(buildArray(new int[] { 1, 3 }, 3));      // [Push, Push, Pop, Push]
        System.out.println(buildArray(new int[] { 1, 2, 3 }, 3));   // [Push, Push, Push]
        System.out.println(buildArray(new int[] { 1, 2 }, 4));      // [Push, Push]
        System.out.println(buildArray(new int[] { 2, 3, 4 }, 4));   // [Push, Pop, Push, Push, Push]
    }

    public static List<String> buildArray(int[] target, int n) {
        final String push = "Push";
        final String pop = "Pop";
        Deque<String> res = new LinkedList<>();

        for (int i = 1, j = 0; j < target.length; i++) {
            res.add(push);

            if (target[j] == i)
                j++;
            else
                res.add(pop);
        }

        return new ArrayList<>(res);
    }
}
