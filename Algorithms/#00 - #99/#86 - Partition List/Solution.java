/**
 * Given a linked list and a value <tt>x</tt>, partition it such that all nodes less than x come before nodes greater than or equal to <tt>x</tt>.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.06.2020
 */
public class Solution {

    public static void main(String... args) {
        partition(new int[] { 1, 4, 3, 2, 5, 2 }, 3);   // 1->2->2->4->3->5
    }

    private static void partition(int[] values, int x) {
        ListNode root = build(values);
        root = partition(root, x);
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

    public static ListNode partition(ListNode head, int x) {
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);
        ListNode oneTail = partition(head, x, one, two);

        head = null;

        if (one.next != null)
            head = one.next;
        if (two.next != null) {
            if (head == null)
                head = two.next;
            else
                oneTail.next = two.next;
        }

        return head;
    }

    private static ListNode partition(ListNode node, int x, ListNode one, ListNode two) {
        while (node != null) {
            ListNode next = node.next;

            if (node.val < x) {
                one.next = node;
                one = node;
                one.next = null;
            } else {
                two.next = node;
                two = node;
                two.next = null;
            }

            node = next;
        }

        return one;
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

        public String toString() {
            return String.valueOf(val);
        }
    }

}
