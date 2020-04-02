/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail
 * connects to. If pos is <tt>-1</tt>, then there is no cycle in the linked list.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * </pre>
 * <b>Follow up:</b>
 * <p>
 * Can you solve it using <tt>O(1)</tt> (i.e. constant) memory?
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(hasCycle(new int[] { 3, 2, 0, -4 }, 1)); // true
        System.out.println(hasCycle(new int[] { 1, 2 }, 0));        // true
        System.out.println(hasCycle(new int[] { 1 }, -1));          // false
    }

    private static boolean hasCycle(int[] values, int pos) {
        return hasCycle(build(values, pos));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        if(head.next == head)
            return true;

        ListNode it1 = head;
        ListNode it2 = head.next;
        boolean match = false;

        while (it2 != null) {
            if (match && it1 == it2)
                return true;

            match = true;
            it1 = it1.next;
            it2 = it2.next;

            if (it2 != null)
                it2 = it2.next;
        }

        return false;
    }

    private static ListNode build(int[] values, int pos) {
        ListNode head = null;
        ListNode prv = null;
        ListNode tmp = null;

        for (int i = 0; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);

            if (head == null)
                head = node;
            else
                prv.next = node;

            prv = node;

            if (i == pos)
                tmp = node;
        }

        if (prv != null)
            prv.next = tmp;

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
