/**
 * Given n non-negative integers <tt>a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub></tt>, where each represents <tt>a</tt> point at coordinate
 * <tt>(i, ai)</tt>. <tt>n</tt> vertical lines are drawn such that the two endpoints of line <tt>i</tt> is at <tt>(i, ai)</tt> and <tt>(i, 0)</tt>.
 * Find two lines, which together with <tt>x-axis</tt> forms a container, such that the container contains the most water.
 * <p>
 * <b>Note:</b> You may not slant the container and n is at least 2.
 * <p>
 * <img src="question_11.jpg" />
 * <p>
 * The above vertical lines are represented by array <tt>[1,8,6,2,5,4,8,3,7]</tt>. In this case, the max area of water (blue section) the container
 * can contain is <tt>49</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 20.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
    }

    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length - 1; i++)
            for (int j = height.length - 1; j > i; j--)
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));

        return max;
    }

}
