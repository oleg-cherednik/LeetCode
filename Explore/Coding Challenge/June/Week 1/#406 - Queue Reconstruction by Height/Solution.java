import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers <tt>(h, k)</tt>, where <tt>h</tt> is
 * the height of the person and <tt>k</tt> is the number of people in front of this person who have a height greater than or equal to <tt>h</tt>.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * <b>Note:</b>
 * The number of people is less than <tt>1,100</tt>.
 * <p>
 * <b>Example</b>
 * <pre>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 06.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reconstructQueueToString(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } }));
        // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    }

    public static String reconstructQueueToString(int[][] people) {
        int[][] res = reconstructQueue(people);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int i = 0; i < res.length; i++) {
            if (i > 0)
                buf.append(", ");
            buf.append('[').append(res[i][0]).append(',').append(res[i][1]).append(']');
        }

        buf.append(']');
        return buf.toString();
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (one, two) -> {
            int res = Integer.compare(two[0], one[0]);
            return res == 0 ? Integer.compare(one[1], two[1]) : res;
        });

        List<int[]> res = new LinkedList<>();

        for (int[] p : people)
            res.add(p[1], p);

        int i = 0;
        int[][] arr = new int[res.size()][2];

        for (int[] p : res)
            arr[i++] = p;

        return arr;
    }

}
