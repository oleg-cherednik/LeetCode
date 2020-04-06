/**
 * Reverse a singly linked list.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * </pre>
 * <b>Follow up:</b>
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author Oleg Cherednik
 * @since 02.04.2019
 */
public class Solution {

    public static void main(String... args) {
        reverseList(1, 2, 3, 4, 5);        // 5->4->3->2->1->NULL
    }

    private static void reverseList(int... values) {
        print(reverseList(build(values)));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prv = null;

        while (head != null) {
            ListNode next = head.next;

            if (prv == null) {
                prv = head;
                prv.next = null;
            } else {
                head.next = prv;
                prv = head;
            }

            head = next;
        }

        return prv;
    }

    private static void print(ListNode node) {
        boolean arrow = false;

        while (true) {
            if (arrow)
                System.out.print("->");

            arrow = true;

            if (node == null) {
                System.out.print("NULL");
                break;
            }
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
