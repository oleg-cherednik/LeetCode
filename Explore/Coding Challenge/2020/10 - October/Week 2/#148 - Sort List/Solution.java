import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the <tt>head</tt> of a linked list, return the <i>list after sorting it in <b>ascending order</b></i>.
 * <p>
 * <b>Follow up:</b> Can you sort the linked list in <tt>O(n logn)</tt> time and <tt>O(1)</tt> memory (i.e. constant space)?
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="sort_list_1.jpg" />
 * <pre>
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * </pre>
 * <b>Example 2:</b>
 * <p>
 * <img src="sort_list_2.jpg" />
 * <pre>
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: head = []
 * Output: []
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The number of nodes in the list is in the range <tt>[0, 5 * 10<sup>4</sup>]</tt>.</li>
 * <li>-10<sup>5</sup> <= Node.val <= 10<sup>5</sup></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.10.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(sortList(4, 2, 1, 3)));      // [1, 2, 3, 4]
        System.out.println(Arrays.toString(sortList(-1, 5, 3, 4, 0)));  // [-1, 0, 3, 4, 5]
        System.out.println(Arrays.toString(sortList()));                // []
    }

    public static int[] sortList(int... vals) {
        ListNode head = build(vals);
        head = sortList(head);

        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode right = head;
        ListNode prev = head;

        while (head != null && head.next != null) {
            head = head.next.next;
            prev = right;
            right = right.next;
        }

        prev.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private static ListNode merge(ListNode one, ListNode two) {
        if (one == null)
            return two;
        if (two == null)
            return one;

        ListNode head = one.val < two.val ? one : two;
        head.next = one.val < two.val ? merge(one.next, two) : merge(one, two.next);

        return head;
    }

    private static ListNode build(int... vals) {
        ListNode head = null;
        ListNode prv = null;

        for (int val : vals) {
            ListNode node = new ListNode(val);

            if (head == null)
                head = node;
            else
                prv.next = node;

            prv = node;
        }

        return head;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
