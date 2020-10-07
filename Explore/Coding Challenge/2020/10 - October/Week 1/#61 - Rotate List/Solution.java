import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a linked list, rotate the list to the right by <tt>k</tt> places, where <tt>k</tt> is non-negative.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 11.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(rotateRight(new int[] { 1, 2, 3, 4, 5 }, 2));    // 4->5->1->2->3
        System.out.println(rotateRight(new int[] { 0, 1, 2 }, 4));          // 2->0->1
        System.out.println(rotateRight(new int[] { 1, 2 }, 1));             // 2->1
    }

    private static String rotateRight(int[] vals, int k) {
        ListNode head = build(vals);
        head = rotateRight(head, k);

        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        int size = 0;
        ListNode node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        if (size == 0 || k % size == 0)
            return head;

        k %= size;
        k = size - k;
        node = head;

        while (--k > 0)
            node = node.next;

        ListNode newHead = node.next;
        ListNode last = node;

        while (node.next != null)
            node = node.next;

        node.next = head;
        last.next = null;

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
    }

}
