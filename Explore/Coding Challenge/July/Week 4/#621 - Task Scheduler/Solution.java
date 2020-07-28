import java.util.Arrays;

/**
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter
 * represents a different task. Tasks could be done without the original order of the array. Each task is done in one
 * unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 * <br>
 * <br>
 * However, there is a non-negative integer <tt>n</tt> that represents the cooldown period between two <b>same
 * tasks</b> (the same letter in the array), that is that there must be at least <tt>n</tt> units of time between any
 * two same tasks.
 * <br>
 * <br>
 * You need to return the <b>least</b> number of units of times that the CPU will take to finish all the given tasks.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of tasks is in the range <tt>[1, 10000]</tt>.</li>
 * <li>The integer <tt>n</tt> is in the range <tt>[0, 100]</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 29.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));  // 8
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));  // 6
        System.out.println(leastInterval(
                new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2)); // 16
    }

    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;

        int[] arr = new int[26];

        for (char task : tasks)
            arr[task - 'A']++;

        Arrays.sort(arr);
        int max = arr[arr.length - 1] - 1;
        int spaces = max * n;

        for (int i = arr.length - 2; i >= 0; i--)
            spaces -= Math.min(max, arr[i]);

        return tasks.length + Math.max(0, spaces);
    }
}
