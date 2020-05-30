import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of <tt>points</tt> on the plane. Find the <tt>K</tt> closest points to the origin <tt>(0, 0)</tt>.
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= K <= points.length <= 10000</tt></li>
 * <li><tt>-10000 < points[i][0] < 10000</tt></li>
 * <li><tt>-10000 < points[i][1] < 10000</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 30.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(kClosestString(new int[][] { { 1, 3 }, { -2, 2 } }, 1));             // [[-2,2]]
        System.out.println(kClosestString(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));  // [[3,3],[-2,4]]
    }

    private static String kClosestString(int[][] points, int K) {
        int[][] res = kClosest(points, K);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int[] point : res) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append('[').append(point[0]).append(',').append(point[1]).append(']');
        }

        buf.append(']');
        return buf.toString();
    }

    public static int[][] kClosest(int[][] points, int K) {
        Queue<Point> minQueue = new PriorityQueue<>(Comparator.comparingLong(one -> one.dist));

        for (int[] point : points)
            minQueue.add(new Point(point[0], point[1]));

        int total = Math.min(minQueue.size(), K);
        int[][] res = new int[total][2];

        for (int i = 0; i < total; i++) {
            Point point = minQueue.remove();
            res[i][0] = point.x;
            res[i][1] = point.y;
        }

        return res;
    }

    private static final class Point {

        private final int x;
        private final int y;
        private final long dist;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = (long)x * x + y * y;
        }
    }

}
