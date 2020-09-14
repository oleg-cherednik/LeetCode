import java.util.Arrays;

/**
 * An <tt>image</tt> is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate <tt>(sr, sc)</tt> representing the starting pixel (row and column) of the flood fill, and a pixel value <tt>newColor</tt>,
 * "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The length of <tt>image</tt> and <tt>image[0]</tt> will be in the range <tt>[1, 50]</tt>.</li>
 * <li>The given starting pixel will satisfy <tt>0 <= sr < image.length and 0 <= sc < image[0].length</tt>.</li>
 * <li>The value of each color in <tt>image[i][j]</tt> and newColor will be an integer in <tt>[0, 65535]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(floodFillToString(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2));  // [[2, 2, 2], [2, 2, 0], [2, 0, 1]]
        System.out.println(floodFillToString(new int[][] { { 0, 0, 0 }, { 0, 1, 0 } }, 1, 1, 2));               // [[0, 0, 0], [0, 2, 0]]
    }

    private static String floodFillToString(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, newColor);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int[] row : image) {
            if (buf.length() > 1)
                buf.append(", ");
            buf.append(Arrays.toString(row));
        }

        buf.append(']');

        return buf.toString();
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return floodFill(image, sr, sc, image[sr][sc], newColor);
    }

    private static int[][] floodFill(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[row].length)
            return image;
        if (image[row][col] != oldColor || image[row][col] == newColor)
            return image;

        image[row][col] = newColor;

        floodFill(image, row, col - 1, oldColor, newColor);
        floodFill(image, row, col + 1, oldColor, newColor);
        floodFill(image, row - 1, col, oldColor, newColor);
        floodFill(image, row + 1, col, oldColor, newColor);

        return image;
    }

}
