import java.util.Arrays;
import java.util.List;

/**
 * Merge <tt>k</tt> sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * <b>Example:</b>
 * <pew>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    public static void main(String... args) {
        mergeKLists(Arrays.asList(
                new int[] { 1, 4, 5 },
                new int[] { 1, 3, 4 },
                new int[] { 2, 6 }));    // 1->1->2->3->4->4->5->6
    }

    private static void mergeKLists(List<int[]> lists) {
        ListNode[] listNodes = lists.stream().map(Solution::build).toArray(ListNode[]::new);
        print(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;

        while (true) {
            int min = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (min == -1 || lists[i].val < lists[min].val)
                    min = i;
            }

            if (min == -1)
                break;

            ListNode node = new ListNode(lists[min].val);

            if (head == null) {
                tail = node;
                head = tail;
            } else {
                tail.next = node;
                tail = tail.next;
            }

            lists[min] = lists[min].next;
        }

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

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

}
