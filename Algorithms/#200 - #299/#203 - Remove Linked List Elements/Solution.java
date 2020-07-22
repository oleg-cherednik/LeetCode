/**
 * Remove all elements from a linked list of integers that have value <b>val</b>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 20.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(removeElements(new int[] { 1, 2, 6, 3, 4, 5, 6 }, 6));   // 1->2->3->4->5
    }

    private static String removeElements(int[] vals, int val) {
        ListNode head = build(vals);
        head = removeElements(head, val);

        StringBuilder buf = new StringBuilder();

        while (head != null) {
            if (buf.length() > 0)
                buf.append("->");
            buf.append(head.val);
            head = head.next;
        }

        return buf.toString();
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode newHead = null;
        ListNode prv = null;

        while (head != null) {
            if (head.val != val) {
                newHead = newHead == null ? head : newHead;

                if (prv != null)
                    prv.next = head;

                prv = head;
            }

            head = head.next;
        }

        if (prv != null)
            prv.next = null;

        return newHead;
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
