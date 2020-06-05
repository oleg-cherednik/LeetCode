import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Given an array <tt>w</tt> of positive integers, where <tt>w[i]</tt> describes the weight of index <tt>i</tt>, write a function <tt>pickIndex</tt>
 * which randomly picks an index in proportion to its weight.
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= w.length <= 10000</tt></li>
 * <li><tt>1 <= w[i] <= 10<sup>5</sup></tt></li>
 * <li><tt>pickIndex</tt> will be called at most <tt>10000</tt> times.</li>
 * </ol>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * </pre>
 * <b>Explanation of Input Syntax:</b>
 * <p>
 * The input is two lists: the subroutines called and their arguments. <tt>Solution</tt>'s constructor has one argument, the array <tt>w</tt>.
 * <tt>pickIndex</tt> has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 * @author Oleg Cherednik
 * @since 05.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(execute(new int[] { 1 }, 1)));       // [0]
        System.out.println(Arrays.toString(execute(new int[] { 1, 3 }, 5)));
    }

    private static int[] execute(int[] w, int pickItemsCount) {
        SolutionB sol = new SolutionB(w);
        int[] res = new int[pickItemsCount];

        for (int i = 0; i < res.length; i++)
            res[i] = sol.pickIndex();

        return res;
    }

    public static class SolutionB {

        private final NavigableMap<Integer, Integer> map = new TreeMap<>();
        private final int total;
        private final Random random = new Random();

        public SolutionB(int[] w) {
            int sum = 0;

            for (int i = 0; i < w.length; i++) {
                sum += i == 0 ? 0 : w[i - 1];
                map.put(sum, i);
            }

            total = sum + w[w.length - 1];
        }

        public int pickIndex() {
            int val = random.nextInt(total);
            return map.floorEntry(val).getValue();
        }
    }

}
