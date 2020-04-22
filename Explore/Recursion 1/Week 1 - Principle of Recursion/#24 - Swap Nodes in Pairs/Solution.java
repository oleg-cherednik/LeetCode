/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may <b>not</b> modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        swapPairs(1, 2, 3, 4);  // 2->1->4->3
    }

    private static void swapPairs(int... values) {
        print(swapPairs(build(values)));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode two = head.next;
        ListNode three = head.next.next;

        two.next = head;
        head.next = swapPairs(three);

        return two;
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
