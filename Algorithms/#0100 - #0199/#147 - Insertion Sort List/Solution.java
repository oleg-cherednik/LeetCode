import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sort a linked list using insertion sort.
 * <p>
 * <img src="Insertion-sort-example-300px.gif" />
 * <p>
 * <sub>A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list</sub>
 * <ol>
 * <b>Algorithm of Insertion Sort:</b>
 * <li>Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.</li>
 * <li>At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it
 * there.</li>
 * <li>It repeats until no input elements remain.</li>
 * </ol>
 * <b>Example 1:</b>
 * <pre>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(insertionSortList(4, 2, 1, 3)));     // [1, 2, 3, 4]
        System.out.println(Arrays.toString(insertionSortList(-1, 5, 3, 4, 0))); // [-1, 0, 3, 4, 5]
    }

    private static int[] insertionSortList(int... vals) {
        ListNode head = build(vals);
        head = insertionSortList(head);

        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static ListNode insertionSortList(ListNode head) {
        return insertionSortList(null, head);
    }

    private static ListNode insertionSortList(ListNode head, ListNode node) {
        if (node == null)
            return head;

        ListNode prv = null;
        ListNode cur = head;
        ListNode next = node.next;

        while (cur != null && cur.val < node.val) {
            prv = cur;
            cur = cur.next;
        }

        if (prv == null) {
            node.next = head;
            head = node;
        } else {
            prv.next = node;
            node.next = cur;
        }

        return insertionSortList(head, next);
    }

    private static ListNode build(int... vals) {
        ListNode head = null;
        ListNode prv = null;

        for (int val : vals) {
            ListNode node = new ListNode(val);

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
