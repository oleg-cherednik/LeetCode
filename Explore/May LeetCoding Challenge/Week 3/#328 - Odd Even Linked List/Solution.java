/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not
 * the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in <tt>O(1)</tt> space complexity and <tt>O(nodes)</tt> time complexity.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The relative order inside both the even and odd groups should remain as it was in the input.</li>
 * <li>The first node is considered odd, the second node even and so on ...</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 16.05.2019
 */
public class Solution {

    public static void main(String... args) {
        oddEvenListAndPrint(1, 2, 3, 4, 5);         // 1->3->5->2->4
        oddEvenListAndPrint(2, 1, 3, 5, 6, 4, 7);   // 2->3->6->7->1->5->4
    }

    private static void oddEvenListAndPrint(int... values) {
        ListNode root = build(values);
        root = oddEvenList(root);
        boolean arrow = false;

        while (root != null) {
            if (arrow)
                System.out.print("->");

            arrow = true;
            System.out.print(root.val);
            root = root.next;
        }

        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode oddHead = null;
        ListNode oddTail = null;

        ListNode evenHead = null;
        ListNode evenTail = null;

        ListNode node = head;
        boolean odd = true;

        while (node != null) {
            if (odd) {
                oddHead = oddHead == null ? node : oddHead;

                if (oddTail != null)
                    oddTail.next = node;

                oddTail = node;
            } else {
                evenHead = evenHead == null ? node : evenHead;

                if (evenTail != null)
                    evenTail.next = node;

                evenTail = node;
            }

            odd = !odd;
            node = node.next;
        }

        oddTail.next = evenHead;

        if (evenTail != null)
            evenTail.next = null;

        return oddHead;
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
