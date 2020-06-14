import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <ol>
 * Implement the class <tt>SubrectangleQueries</tt> which receives a <tt>rows x cols</tt> rectangle as a matrix of integers in the constructor and
 * supports two methods:
 * <li>
 * <tt>updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)</tt>
 * <ul>
 * <li>Updates all values with <tt>newValue</tt> in the subrectangle whose upper left coordinate is <tt>(row1,col1)</tt> and bottom right coordinate
 * is <tt>(row2,col2)</tt>.
 * </li>
 * </ul>
 * </li>
 * <li>
 * <tt>getValue(int row, int col)</tt>
 * <ul>
 * <li>Returns the current value of the coordinate <tt>(row,col)</tt> from the rectangle.</li>
 * </ul>
 * </li>
 * </ol>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * Output
 * [null,1,null,5,5,null,10,5]
 * Explanation
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // The initial rectangle (4x3) looks like:
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // return 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // After this update the rectangle looks like:
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // return 5
 * subrectangleQueries.getValue(3, 1); // return 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // After this update the rectangle looks like:
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // return 10
 * subrectangleQueries.getValue(0, 2); // return 5
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * Output
 * [null,1,null,100,100,null,20]
 * Explanation
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // return 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // return 100
 * subrectangleQueries.getValue(2, 2); // return 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // return 20
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>There will be at most <tt>500</tt> operations considering both methods: <tt>updateSubrectangle</tt> and <tt>getValue</tt>.</li>
 * <li><tt>1 <= rows, cols <= 100</tt></li>
 * <li><tt>rows == rectangle.length</tt></li>
 * <li><tt>cols == rectangle[i].length</tt></li>
 * <li><tt>0 <= row1 <= row2 < rows</tt></li>
 * <li><tt>0 <= col1 <= col2 < cols</tt></li>
 * <li><tt>1 <= newValue, rectangle[i][j] <= 10<sup>9</sup></tt></li>
 * <li><tt>0 <= row < rows</tt></li>
 * <li><tt>0 <= col < cols</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(exampleOne());   // [1, 5, 5, 10, 5]
        System.out.println(exampleTwo());   // [1, 100, 100, 20]
    }

    private static List<Integer> exampleOne() {
        List<Integer> res = new ArrayList<>();
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][] { { 1, 2, 1 }, { 4, 3, 3 }, { 3, 2, 1 }, { 1, 1, 1 } });
        res.add(subrectangleQueries.getValue(0, 2));
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        res.add(subrectangleQueries.getValue(0, 2));
        res.add(subrectangleQueries.getValue(3, 1));
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        res.add(subrectangleQueries.getValue(3, 1));
        res.add(subrectangleQueries.getValue(0, 2));
        return res;
    }

    private static List<Integer> exampleTwo() {
        List<Integer> res = new ArrayList<>();
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][] { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } });
        res.add(subrectangleQueries.getValue(0, 0));
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        res.add(subrectangleQueries.getValue(0, 0));
        res.add(subrectangleQueries.getValue(2, 2));
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        res.add(subrectangleQueries.getValue(2, 2));
        return res;
    }

    public static class SubrectangleQueries {

        private final int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = new int[rectangle.length][];

            for (int row = 0; row < rectangle.length; row++)
                this.rectangle[row] = Arrays.copyOf(rectangle[row], rectangle[row].length);
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int row = row1; row <= row2; row++)
                for (int col = col1; col <= col2; col++)
                    rectangle[row][col] = newValue;
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }

}
