/**
 * Given a singly linked list <tt>L: L<sub>0</sub>→L<sub>1</sub>→…→L<sub>n-1</sub>→L<sub>n</sub></tt>,
 * reorder it to: <tt>L<sub>0</sub>→L<sub>n</sub>→L<sub>1</sub>→L<sub>n-1</sub>→L<sub>2</sub>→L<sub>n-2</sub>→…</tt>
 * <p>
 * You may <b>not</b> modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * </pre.
 *
 * @author Oleg Cherednik
 * @since 20.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(reorderList(1, 2, 3, 4));    // 1->4->2->3
        System.out.println(reorderList(1, 2, 3, 4, 5)); // 1->5->2->4->3
    }

    private static String reorderList(int... values) {
        ListNode node = reorderList(build(values));
        StringBuilder buf = new StringBuilder();

        while (node != null) {
            if (buf.length() > 0)
                buf.append("->");
            buf.append(node.val);
            node = node.next;
        }

        return buf.toString();
    }

    public static ListNode reorderList(ListNode head) {
        reorderList(head, new Data(head));
        return head;
    }

    private static boolean reorderList(ListNode node, Data data) {
        if (node == null)
            data.build = true;
        else {
            if (!data.build) {
                if (reorderList(node.next, data))
                    node.next = null;
                else
                    return false;
            }

            ListNode next = data.prv.next;

            if (next == null || data.prv.next == node)
                return false;

            data.prv.next = node;
            node.next = next;
            data.prv = next;
        }

        return true;
    }

    private static final class Data {

        ListNode prv;
        boolean build;

        public Data(ListNode prv) {
            this.prv = prv;
        }
    }

    private static ListNode build(int... values) {
        ListNode head = null;
        ListNode prv = null;

        for (int value : values) {
            ListNode node = new ListNode(value);
            head = head == null ? node : head;

            if (prv != null)
                prv.next = node;

            prv = node;
        }

        return head;
    }

    private static class ListNode {

        final int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
