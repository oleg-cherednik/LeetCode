/**
 * Given a linked list, reverse the nodes of a linked list <tt>k</tt> at a time and return its modified list.
 * <p>
 * <tt>k</tt> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then
 * left-out nodes in the end should remain as it is.
 * <p>
 * <b>Example:</b>
 * <p>
 * Given this linked list: <tt>1->2->3->4->5</tt>
 * <p>
 * For <tt>k = 2</tt>, you should return: <tt>2->1->4->3->5</tt>
 * <p>
 * For <tt>k = 3</tt>, you should return: <tt>3->2->1->4->5</tt>
 * <ul>
 * <b>Note:</b>
 * <li>Only constant extra memory is allowed.</li>
 * <li>You may not alter the values in the list's nodes, only nodes itself may be changed.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 09.05.2020
 */
public class Solution {

    public static void main(String... args) {
        reverseKGroup(new int[] { 1, 2, 3, 4, 5 }, 2);  // 2->1->4->3->5
        reverseKGroup(new int[] { 1, 2, 3, 4, 5 }, 3);  // 3->2->1->4->5
    }

    private static void reverseKGroup(int[] values, int k) {
        print(reverseKGroup(build(values), k));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 1)
            return head;

        ListNode groupHead = head;
        ListNode groupTail = head;
        ListNode preGroupHead = null;

        int i = 1;

        while (groupTail != null) {
            if (i % k == 0) {
                ListNode nextGroupHead = groupTail.next;
                ListNode groupNewHead = groupTail;
                groupTail = reverseGetTail(groupHead, groupTail);
                groupTail.next = nextGroupHead;
                groupHead = groupNewHead;

                if (preGroupHead == null)
                    head = groupHead;
                else
                    preGroupHead.next = groupHead;

                preGroupHead = groupTail;
                groupTail = preGroupHead.next;
                groupHead = groupTail;
                i = 1;
            } else {
                groupTail = groupTail.next;
                i++;
            }
        }

        return head;
    }

    private static ListNode reverseGetTail(ListNode head, ListNode tail) {
        if (head == tail)
            return tail;

        tail = reverseGetTail(head.next, tail);
        tail.next = head;
        return tail.next;
    }

    private static void print(ListNode node) {
        boolean arrow = false;

        while (node != null) {
            if (arrow)
                System.out.print("->");

            arrow = true;
            System.out.print(node.val);
            node = node.next;
        }

        System.out.println();
    }

    private static ListNode build(int... values) {
        ListNode head = null;
        ListNode prv = null;

        for (int value : values) {
            ListNode node = new ListNode(value);

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
