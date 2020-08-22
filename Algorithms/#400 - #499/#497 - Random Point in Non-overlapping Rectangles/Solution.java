import java.util.Arrays;
import java.util.Random;

/**
 * Given a list of <b>non-overlapping</b> axis-aligned rectangles <tt>rects</tt>, write a function <tt>pick</tt> which
 * randomly and uniformily picks an <b>integer point</b> in the space covered by the rectangles.
 * <ol>
 * <b>Note:</b>
 * <li>An <b>integer point</b> is a point that has integer coordinates.</li>
 * <li>A point on the perimeter of a rectangle is <b>included</b> in the space covered by the rectangles.</li>
 * <li><tt>i<sup>th</sup> rectangle = rects[i] = [x1,y1,x2,y2]</tt>, where <tt>[x1, y1]</tt> are the integer coordinates
 * of the bottom-left corner, and <tt>[x2, y2]</tt> are the integer coordinates of the top-right corner.</li>
 * <li>length and width of each rectangle does not exceed <tt>2000</tt>.</li>
 * <li><tt>1 <= rects.length <= 100</tt></li>
 * <li><tt>pick</tt> return a point as an array of integer coordinates <tt>[p_x, p_y]</tt></li>
 * <li><tt>pick</tt> is called at most <tt>10000</tt> times.</li>
 * </ol>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * </pre>
 * <b>Explanation of Input Syntax:</b>
 * <p>
 * The input is two lists: the subroutines called and their arguments. <tt>Solution's</tt> constructor has one argument,
 * the array of rectangles <tt>rects</tt>. <tt>pick</tt> has no arguments. Arguments are always wrapped with a list,
 * even if there aren't any.
 *
 * @author Oleg Cherednik
 * @since 22.08.2020
 */
public class Solution {

    public static void main(String... args) {
        exampleOne();
        System.out.println();
        exampleTwo();
    }

    private static void exampleOne() {
        Solution obj = new Solution(new int[][] { { 1, 1, 5, 5 } });
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }

    private static void exampleTwo() {
        Solution obj = new Solution(new int[][] { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } });
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }

    private final int[][] rects;
    private final int[] sums;
    private final Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        sums = new int[rects.length];
        int sum = 0;

        for (int i = 0; i < rects.length; i++)
            sums[i] = sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
    }

    public int[] pick() {
        int target = random.nextInt(sums[sums.length - 1]);
        int low = 0;
        int high = sums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (target < sums[mid])
                high = mid;
            else
                low = mid + 1;
        }

        return pickFromRect(rects[low]);
    }

    private int[] pickFromRect(int[] rect) {
        return new int[] { rect[0] + random.nextInt(rect[2] - rect[0] + 1),
                rect[1] + random.nextInt(rect[3] - rect[1] + 1) };
    }

}
