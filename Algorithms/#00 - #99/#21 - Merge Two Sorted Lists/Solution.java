/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.04.2020
 */
public class Solution {

    public static void main(String... args) {
        mergeTwoLists(new int[] { 1, 2, 4 }, new int[] { 1, 3, 4 });    // 1->1->2->3->4->4
    }

    private static void mergeTwoLists(int[] one, int[] two) {
        ListNode l1 = build(one);
        ListNode l2 = build(two);
        print(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = null;
        ListNode prv = null;

        while (l1 != null && l2 != null) {
            ListNode node;

            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            node.next = null;

            if (head == null)
                head = node;
            if (prv != null)
                prv.next = node;

            prv = node;
        }

        prv.next = l1 == null ? l2 : l1;

        return head;
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
