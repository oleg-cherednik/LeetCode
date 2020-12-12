import java.util.Arrays;

/**
 * Reverse a linked list from position <tt>m</tt> to <tt>n</tt>. Do it in one-pass.
 * <p>
 * <b>Note:</b> <tt>1 ≤ m ≤ n ≤ length of list</tt>.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(reverseBetween(new int[] { 1, 2, 3, 4, 5 }, 2, 4)));   // [1, 4, 3, 2, 5]
        System.out.println(Arrays.toString(reverseBetween(new int[] { 1, 2, 3, 4, 5 }, 2, 2)));   // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(reverseBetween(new int[] { 1, 2, 3, 4, 5 }, 1, 5)));   // [5, 4, 3, 2, 1]
    }

    private static int[] reverseBetween(int[] values, int m, int n) {
        ListNode head = reverseBetween(build(values), m, n);

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

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prvHead = new ListNode(-1);
        prvHead.next = head;

        ListNode prv = prvHead;

        for (int i = 1; i < m; i++)
            prv = prv.next;

        ListNode tail = prv.next;

        for (int i = m; i < n; i++) {
            ListNode node = tail.next;
            tail.next = node.next;
            node.next = prv.next;
            prv.next = node;
        }

        head = prvHead.next;
        prvHead.next = null;
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
