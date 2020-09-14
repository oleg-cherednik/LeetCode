import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer <tt>n</tt> representing the total number of bits in the code, print the sequence of gray code. A gray code sequence
 * must begin
 * with <tt>0</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(grayCode(0));    // [0]
        System.out.println(grayCode(1));    // [0, 1]
        System.out.println(grayCode(2));    // [0, 1, 3, 2]
        System.out.println(grayCode(3));    // [0, 1, 3, 2, 6, 7, 5, 4]
    }

    public static List<Integer> grayCode(int n) {
        return grayCode(n, new ArrayList<>(), 0);
    }

    private static List<Integer> grayCode(int n, List<Integer> m, int depth) {
        if (n < depth)
            return m;

        if (depth == 0)
            m.add(0);
        else {
            int t = 1 << (depth - 1);

            for (int i = 0; i < t; i++)
                m.add(m.get(t - i - 1) + (1 << (depth - 1)));
        }

        return grayCode(n, m, depth + 1);
    }

}
