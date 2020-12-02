/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the <b>same probability</b> of being chosen.
 * <p>
 * <b>Follow up:</b><br>
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * <p>
 * <b>Example:</b>
 * <pre>
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 02.12.2020
 */
public class Solution {

    private final ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1;
        int res = 0;

        ListNode node = head;

        while (node != null) {
            if (Math.random() < 1.0 / scope)
                res = node.val;

            scope += 1;
            node = node.next;
        }
        return res;
    }

    public static void main(String... args) {
        ListNode head = build(1, 2, 3);
        Solution solution = new Solution(head);

        for (int i = 0; i < 10; i++)
            System.out.println(solution.getRandom());
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
