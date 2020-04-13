import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <ul>
 * Each turn, we choose the two <b>heaviest</b> stones and smash them together. Suppose the stones have weights <tt>x</tt> and <tt>y</tt> with <tt>x
 * <= y</tt>. The result of this smash is:
 * <li>If <tt>x == y</tt>, both stones are totally destroyed;</li>
 * <li>If <tt>x != y</tt>, the stone of weight <tt>x</tt> is totally destroyed, and the stone of weight <tt>y</tt> has new weight <tt>y-x</tt>.</li>
 * </ul>
 * At the end, there is at most <tt>1</tt> stone left. Return the weight of this stone (or <tt>0</tt> if there are no stones left).
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>1 <= stones.length <= 30</tt></li>
 * <li><tt>1 <= stones[i] <= 1000</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));    // 1
        System.out.println(lastStoneWeight(new int[] { 2, 2 }));                // 0
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones)
            maxHeap.add(stone);

        while (maxHeap.size() > 1) {
            int one = maxHeap.poll();
            int two = maxHeap.poll();

            if (one > two)
                maxHeap.add(one - two);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
