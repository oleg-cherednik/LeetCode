import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <ul>
 * Implement the <tt>FirstUnique</tt> class:
 * <li><tt>FirstUnique(int[] nums)</tt> Initializes the object with the numbers in the queue.</li>
 * <li><tt>int showFirstUnique()</tt> returns the value of <b>the first unique</b> integer of the queue, and returns <b>-1</b> if there is no such integer.</li>
 * <li><tt>void add(int value)</tt> insert value to the queue.</li>
 * </ul>
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= nums.length <= 10<sup>5</sup></tt></li>
 * <li><tt>1 <= nums[i] <= 10<sup>8</sup></tt></li>
 * <li><tt>1 <= value <= 10<sup>8</sup></tt></li>
 * <li>At most <tt>50000</tt> calls will be made to <tt>showFirstUnique</tt> and <tt>add</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 28.04.2020
 */
public class Solution {

    public static void main(String... args) {
        one();
        two();
        three();
    }

    private static void one() {
        FirstUnique firstUnique = new FirstUnique(new int[] { 2, 3, 5 });
        System.out.println(firstUnique.showFirstUnique());  // return 2
        firstUnique.add(5);                                 // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique());  // return 2
        firstUnique.add(2);                                 // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique());  // return 3
        firstUnique.add(3);                                 // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique());  // return -1
        System.out.println();
    }

    private static void two() {
        FirstUnique firstUnique = new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7 });
        System.out.println(firstUnique.showFirstUnique());  // return -1
        firstUnique.add(7);                                 // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);                                 // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);                                 // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);                                 // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);                                // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique());  // return 17
        System.out.println();
    }

    private static void three() {
        FirstUnique firstUnique = new FirstUnique(new int[] { 809 });
        System.out.println(firstUnique.showFirstUnique());  // return 809
        firstUnique.add(809);                               // the queue is now [809,809]
        System.out.println(firstUnique.showFirstUnique());  // return -1
        System.out.println();
    }

    public static class FirstUnique {

        private final Set<Integer> notUnique = new HashSet<>();
        private final Set<Integer> unique = new LinkedHashSet<>();

        public FirstUnique(int[] nums) {
            if (nums == null)
                return;

            for (int num : nums)
                add(num);
        }

        public int showFirstUnique() {
            return unique.isEmpty() ? -1 : unique.iterator().next();
        }

        public void add(int value) {
            if (notUnique.contains(value))
                return;

            if (unique.contains(value)) {
                notUnique.add(value);
                unique.remove(value);
            } else
                unique.add(value);
        }
    }

}
