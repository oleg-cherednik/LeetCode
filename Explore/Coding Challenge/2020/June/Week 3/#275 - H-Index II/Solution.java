/**
 * Given an array of citations <b>sorted in ascending order</b> (each citation is a non-negative integer) of a researcher, write a function to
 * compute the researcher's h-index.
 * <p>
 * According to the <a href="https://en.wikipedia.org/wiki/H-index">definition of h-index on Wikipedia</a>: "A scientist has index <tt>h</tt> if
 * <tt>h</tt> of his/her <tt>N</tt> papers have <b>at least</b> <tt>h</tt> citations each, and the other <tt>N − h</tt> papers have <b>no more
 * than</b> <tt>h</tt> citations each."
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * </pre>
 * <b>Note:</b>
 * <p>
 * If there are several possible values for <tt>h</tt>, the maximum one is taken as the <tt>h-index</tt>.
 * <ul>
 * <b>Follow up:</b>
 * <li>This is a follow up problem to <u>274. H-Index</u>, where <tt>citations</tt> is now guaranteed to be sorted in ascending order.</li>
 * <li>Could you solve it in logarithmic time complexity?</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 18.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hIndex(new int[] { 0, 1, 3, 5, 6 }));    // 3
        System.out.println(hIndex(new int[] { 1 }));                // 1
        System.out.println(hIndex(new int[0]));                     // 0
        System.out.println(hIndex(new int[] { 100 }));              // 1
        System.out.println(hIndex(new int[] { 0 }));                // 0
    }

    public static int hIndex(int[] citations) {
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
