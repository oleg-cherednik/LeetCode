/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only <i>distinct</i> numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 1->1->1->2->3
 * Output: 2->3
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.04.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(deleteDuplicates(1, 2, 3, 3, 4, 4, 5));          // 1->2->5
        System.out.println(deleteDuplicates(1, 2, 3, 4, 5));                // 1->2->3->4->5
        System.out.println(deleteDuplicates(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)); // null
        System.out.println(deleteDuplicates());                             // null
    }

    private static String deleteDuplicates(int... values) {
        ListNode root = build(values);
        root = deleteDuplicates(root);

        StringBuilder buf = new StringBuilder();

        while (root != null) {
            if (buf.length() != 0)
                buf.append("->");
            buf.append(root.val);
            root = root.next;
        }

        return buf.length() == 0 ? null : buf.toString();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = null;
        ListNode newTail = null;

        ListNode prv = null;
        int count = 0;

        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;

            if (prv == null) {
                prv = node;
                count = 1;
            } else if (node.val == prv.val)
                count++;
            else {
                if (count == 1) {
                    if (newHead == null)
                        newHead = prv;
                    else
                        newTail.next = prv;

                    newTail = prv;
                    newTail.next = null;
                }

                prv = node;
                count = 1;
            }

            node = next;
        }

        if (count == 1) {
            if (newHead == null)
                newHead = prv;
            else
                newTail.next = prv;

            newTail = prv;
            newTail.next = null;
        }

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


    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
