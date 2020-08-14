import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of <a href="https://en.wikipedia.org/wiki/H-index">h-index on Wikipedia</a>: "A scientist has index <tt>h</tt> if
 * <tt>h</tt> of his/her <tt>N</tt> papers have <b>at least</b> <tt>h</tt> citations each, and the other <tt>N − h</tt> papers have <b>no more
 * than</b> <tt>h</tt> citations each."
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * </pre>
 * <b>Note:</b> If there are several possible values for <tt>h</tt>, the maximum one is taken as the h-index.
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));    // 3
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int min = 1;
        int max = citations.length;
        int h = 0;

        boolean flag = false;

        while (min <= max) {
            int mid = (min + max) / 2;
            int papers = citations.length - mid;

            if (papers >= 0 && citations[papers] >= mid) {
                h = mid;
                min = mid + 1;
            } else
                max = mid;

            if (min != max)
                continue;
            if (flag)
                break;

            flag = true;
        }

        return h;
    }

}
