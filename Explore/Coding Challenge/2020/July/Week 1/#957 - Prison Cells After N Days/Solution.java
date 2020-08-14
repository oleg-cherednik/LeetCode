import java.util.Arrays;

/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * <ul>
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * <li>If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.</li>
 * <li>Otherwise, it becomes vacant.</li>
 * </ul>
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 * <p>
 * We describe the current state of the prison in the following way: <tt>cells[i] == 1</tt> if the <tt>i-th</tt> cell is occupied, else
 * <tt>cells[i] == 0</tt>.
 * <p>
 * Given the initial state of the prison, return the state of the prison after <tt>N</tt> days (and <tt>N</tt> such changes described above.)
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>cells.length == 8</tt></li>
 * <li><tt>cells[i]</tt> is in <tt>{0, 1}</tt></li>
 * <li><tt>1 <= N <= 10<sup>9</sup></tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 03.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));             // [0, 0, 1, 1, 0, 0, 0, 0]
        System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 1, 0 }, 1000000000)));    // [0, 0, 1, 1, 1, 1, 1, 0]
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] res = new int[8];
        N = N % 14 == 0 ? 14 : N % 14;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 7; j++)
                res[j] = cells[j + 1] == cells[j - 1] ? 1 : 0;
            cells = Arrays.copyOf(res, res.length);
        }

        return res;
    }

}
