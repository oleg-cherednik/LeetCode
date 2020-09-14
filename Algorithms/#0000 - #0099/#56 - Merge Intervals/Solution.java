import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));  // [[1, 6], [8, 10], [15, 18]]
    }

    public static int[][] merge(int[][] intervals) {
        Set<Interval> sortedIntervals = new TreeSet<>(Comparator.comparingInt((Interval one) -> one.from).thenComparingInt(one -> one.to));

        for (int[] interval : intervals)
            sortedIntervals.add(new Interval(interval));

        Deque<Interval> queue = new LinkedList<>();

        for (Interval interval : sortedIntervals) {
            if (queue.isEmpty())
                queue.add(interval);
            else {
                Interval prv = queue.getLast();

                if (prv.to >= interval.from)
                    prv.to = Math.max(prv.to, interval.to);
                else
                    queue.add(interval);
            }
        }

        int i = 0;
        int[][] res = new int[queue.size()][2];

        while (!queue.isEmpty()) {
            Interval interval = queue.remove();
            res[i++] = new int[] { interval.from, interval.to };
        }

        return res;
    }

    private static final class Interval {

        public int from;
        public int to;

        public Interval(int[] interval) {
            from = interval[0];
            to = interval[1];
        }

    }

}
