/**
 * Given a non-empty, singly linked list with head node <tt>head</tt>, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The number of nodes in the given list will be between <tt>1 and </tt>100</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 07.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(middleNode(build(1, 2, 3, 4, 5)).val);       // 3
        System.out.println(middleNode(build(1, 2, 3, 4, 5, 6)).val);    // 4
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode one = head;
        ListNode two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }

        return one;
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
