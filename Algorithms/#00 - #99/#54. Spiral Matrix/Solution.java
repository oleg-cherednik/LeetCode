import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of <tt>m x n</tt> elements (<tt>m</tt> rows, <tt>n</tt> columns), return all elements of the matrix in spiral order.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(spiralOrder(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } }));    // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrder(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } }));  // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        System.out.println(spiralOrder(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } })); // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0)
            return Collections.emptyList();

        final int height = matrix.length;
        final int width = matrix[0].length;

        List<Integer> res = new LinkedList<>();
        boolean[][] used = new boolean[height][width];

        Point point = new Point();
        Direction direction = Direction.RIGHT;
        boolean found;

        do {
            res.add(matrix[point.row][point.col]);
            used[point.row][point.col] = true;
            found = false;

            for (int i = 0; i < 4 && !found; i++) {
                if (direction.isNextUsed(used, point))
                    direction = direction.next();
                else {
                    direction.move(point);
                    found = true;
                }
            }
        } while (found);

        return res;
    }

    private static final class Point {

        int row;
        int col;
    }

    private enum Direction {
        RIGHT {
            @Override
            public boolean isNextUsed(boolean[][] used, Point point) {
                return isUsed(used, point.row, point.col + 1);
            }

            @Override
            public Direction next() {
                return DOWN;
            }

            @Override
            public void move(Point point) {
                point.col++;
            }
        },
        DOWN {
            @Override
            public boolean isNextUsed(boolean[][] used, Point point) {
                return isUsed(used, point.row + 1, point.col);
            }

            @Override
            public Direction next() {
                return LEFT;
            }

            @Override
            public void move(Point point) {
                point.row++;
            }
        },
        LEFT {
            @Override
            public boolean isNextUsed(boolean[][] used, Point point) {
                return isUsed(used, point.row, point.col - 1);
            }

            @Override
            public Direction next() {
                return UP;
            }

            @Override
            public void move(Point point) {
                point.col--;
            }
        },
        UP {
            @Override
            public boolean isNextUsed(boolean[][] used, Point point) {
                return isUsed(used, point.row - 1, point.col);
            }

            @Override
            public Direction next() {
                return RIGHT;
            }

            @Override
            public void move(Point point) {
                point.row--;
            }
        };

        public abstract boolean isNextUsed(boolean[][] used, Point point);

        public abstract Direction next();

        public abstract void move(Point point);

        private static boolean isUsed(boolean[][] used, int row, int col) {
            if (row < 0 || row >= used.length)
                return true;
            if (col < 0 || col >= used[row].length)
                return true;
            return used[row][col];
        }
    }

}
