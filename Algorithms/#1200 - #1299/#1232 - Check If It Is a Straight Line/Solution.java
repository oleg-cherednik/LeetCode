/**
 * You are given an array <tt>coordinates</tt>, <tt>coordinates[i] = [x, y]</tt>, where <tt>[x, y]</tt> represents the coordinate of a point. Check if
 * these points make a straight line in the <tt>XY</tt> plane.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="untitled-diagram-2.jpg" />
 * <pre>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="untitled-diagram-1.jpg" />
 * <pre>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>2 <= coordinates.length <= 1000</tt></li>
 * <li><tt>coordinates[i].length == 2</tt></li>
 * <li><tt>-10^4 <= coordinates[i][0]</tt>, <tt>coordinates[i][1] <= 10^4</tt></li>
 * <li><tt>coordinates</tt> contains no duplicate point.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 08.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));   // true
        System.out.println(checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }));   // false
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        if (x1 == x2) {
            for (int[] coordinate : coordinates)
                if (coordinate[0] != x1)
                    return false;
        } else if (y1 == y2) {
            for (int[] coordinate : coordinates)
                if (coordinate[1] != y1)
                    return false;
        } else {
            for (int[] coordinate : coordinates) {
                int x = coordinate[0];
                int y = coordinate[1];

                if ((x - x1) / (x2 - x1) != (y - y1) / (y2 - y1))
                    return false;
            }
        }

        return true;
    }
}
