/**
 * Given a sorted linked list, delete all duplicates such that each element appear only <i>once</i>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1->1->2
 * Output: 1->2
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 09.04.2020
 */
public class Solution {

    public static void main(String... args) {
        deleteDuplicatesAndPrint(1, 1, 2);          // 1->2
        deleteDuplicatesAndPrint(1, 1, 2, 3, 3);    // 1->2->3
    }

    private static void deleteDuplicatesAndPrint(int... values) {
        ListNode root = build(values);
        root = deleteDuplicates(root);
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode root = null;
        ListNode prv = null;
        ListNode node = head;

        while (node != null) {
            if (prv == null) {
                prv = node;
                root = node;
            } else if (prv.val != node.val) {
                prv.next = node;
                prv = node;
            }

            node = node.next;
        }

        if (prv != null)
            prv.next = null;

        return root;
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
