import java.util.Arrays;

/**
 * Given a linked list, remove the <i>n-th</i> node from the end of list and return its head.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * </pre>
 * <b>Note:</b>
 * <p>
 * Given <tt>n</tt> will always be valid.
 * <p>
 * <b>Follow up:</b>
 * <p>
 * Could you do this in one pass?
 *
 * @author Oleg Cherednik
 * @since 11.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 0)));   // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 1)));   // [1, 2, 3, 4]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 2)));   // [1, 2, 3, 5]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 3)));   // [1, 2, 4, 5]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 4)));   // [1, 3, 4, 5]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 5)));   // [2, 3, 4, 5]
        System.out.println(Arrays.toString(removeNthFromEnd(new int[] { 1, 2, 3, 4, 5 }, 6)));   // [1, 2, 3, 4, 5]
    }

    private static int[] removeNthFromEnd(int[] values, int n) {
        ListNode head = removeNthFromEnd(build(values), n);

        if (head == null)
            return new int[0];

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        int[] res = new int[size];
        int i = 0;

        while (head != null) {
            res[i++] = head.val;
            head = head.next;
        }

        return res;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1)
            return head;

        int i = -n;
        ListNode one = head;
        ListNode two = null;

        while (one != null) {
            one = one.next;
            two = i == 0 ? head : two == null ? null : two.next;
            i++;
        }

        if (i == 0) {
            ListNode next = head.next;
            head.next = null;
            head = next;
        } else if (i > 0) {
            ListNode next = two.next.next;
            two.next.next = null;
            two.next = next;
        }

        return head;
    }

    private static ListNode build(int... values) {
        ListNode head = null;
        ListNode prv = null;

        for (int val : values) {
            ListNode node = new ListNode(val);

            if (prv == null)
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
