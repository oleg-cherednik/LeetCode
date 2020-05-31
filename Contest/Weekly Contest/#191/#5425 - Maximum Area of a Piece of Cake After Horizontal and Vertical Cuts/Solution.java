import java.util.Arrays;

/**
 * Given a rectangular cake with height <tt>h</tt> and width <tt>w</tt>, and two arrays of integers <tt>horizontalCuts</tt> and <tt>verticalCuts</tt>
 * where <tt>horizontalCuts[i]</tt> is the distance from the top of the rectangular cake to the <tt>i<sub>th</sub></tt> horizontal cut and similarly,
 * <tt>verticalCuts[j]</tt> is the distance from the left of the rectangular cake to the <tt>j<sub>th</sub></tt> vertical cut.
 * <p>
 * <i>Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays <tt>horizontalCuts</tt>
 * and <tt>verticalCuts</tt></i>. Since the answer can be a huge number, return this modulo <tt>10<sup>9</sup> + 7</tt>.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="leetcode_max_area_2.png" />
 * <pre>
 * Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * Output: 4
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the
 * green piece of cake has the maximum area.
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="leetcode_max_area_3.png" />
 * <pre>
 * Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * Output: 6
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the
 * green and yellow pieces of cake have the maximum area.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * Output: 9
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= h, w <= 10<sup>9</sup></tt></li>
 * <li><tt>1 <= horizontalCuts.length < min(h, 10<sup>5</sup>)</tt></li>
 * <li><tt>1 <= verticalCuts.length < min(w, 10<sup>5</sup>)</tt></li>
 * <li><tt>1 <= horizontalCuts[i] < h</tt></li>
 * <li><tt>1 <= verticalCuts[i] < w</tt></li>
 * <li>It is guaranteed that all elements in <tt>horizontalCuts</tt> are distinct.</li>
 * <li>It is guaranteed that all elements in <tt>verticalCuts</tt> are distinct.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 31.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));   // 4
        System.out.println(maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));         // 6
        System.out.println(maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));            // 9
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxWidth = verticalCuts[0];
        long maxHeight = horizontalCuts[0];

        for (int i = 0, j = 1; j <= horizontalCuts.length; i++, j++) {
            int height = (j == horizontalCuts.length ? h : horizontalCuts[j]) - horizontalCuts[i];
            maxHeight = Math.max(maxHeight, height);
        }

        for (int i = 0, j = 1; j <= verticalCuts.length; i++, j++) {
            int width = (j == verticalCuts.length ? w : verticalCuts[j]) - verticalCuts[i];
            maxWidth = Math.max(maxWidth, width);
        }

        final int modulo = 1_000_000_007;
        maxWidth %= modulo;
        maxHeight %= modulo;


        return (int)((maxHeight * maxWidth) % modulo);
    }

}
