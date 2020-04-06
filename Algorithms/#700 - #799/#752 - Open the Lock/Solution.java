import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: <tt>'0'</tt>, <tt>'1'</tt>, <tt>'2'</tt>, <tt>'3'</tt>,
 * <tt>'4'</tt>, <tt>'5'</tt>, <tt>'6'</tt>, <tt>'7'</tt>, <tt>'8'</tt>, <tt>'9'</tt>. The wheels can rotate freely and wrap around: for example we
 * can turn <tt>'9'</tt> to be <tt>'0'</tt>, or <tt>'0'</tt> to be <tt>'9'</tt>. Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at <tt>'0000'</tt>, a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of <tt>deadends</tt> dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and
 * you will be unable to open it.
 * <p>
 * Given a <tt>target</tt> representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open
 * the lock, or <tt>-1</tt> if it is impossible.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * </pre>
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * </pre>
 * <p>
 * <b>Example 3:</b>
 * <pre>
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * </pre>
 * <p>
 * <b>Note:</b>
 * <ol>
 * <li>The length of <tt>deadends</tt> will be in the range <tt>[1, 500]</tt>.</li>
 * <li><tt>target</tt> will not be in the list <tt>deadends</tt>.</li>
 * <li>Every string in <tt>deadends</t> and the string <tt>target</t> will be a string of 4 digits from the <tt>10,000</tt> possibilities
 * <tt>'0000'</tt> to <tt>'9999'</tt>.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 31.03.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));      // 6
        System.out.println(openLock(new String[] { "8888" }, "0009"));    // 1
        System.out.println(openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));      // -1
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String lock = Objects.requireNonNull(queue.poll());

                if (!visited.add(lock))
                    continue;
                if (lock.equals(target))
                    return turns;

                for (String nextLock : getNextStates(lock))
                    if (!visited.contains(nextLock))
                        queue.add(nextLock);
            }

            turns++;
        }

        return -1;
    }

    private static List<String> getNextStates(String lock) {
        List<String> locks = new ArrayList<>(8);
        char[] arr = lock.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            arr[i] = ch == '9' ? '0' : (char)(ch + 1);
            locks.add(String.valueOf(arr));

            arr[i] = ch == '0' ? '9' : (char)(ch - 1);
            locks.add(String.valueOf(arr));

            arr[i] = ch;
        }

        return locks;
    }

}
