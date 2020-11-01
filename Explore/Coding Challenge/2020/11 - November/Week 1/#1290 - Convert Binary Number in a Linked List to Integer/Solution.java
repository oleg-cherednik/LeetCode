/**
 * Given <tt>head</tt> which is a reference node to a singly-linked list. The value of each node in the linked list is either <tt>0</tt> or
 * <tt>1</tt>. The linked list holds the binary representation of a number.
 * <p>
 * Return the <i>decimal value</i> of the number in the linked list.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="graph-1.png" />
 * <pre>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: head = [0]
 * Output: 0
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: head = [1]
 * Output: 1
 * </pre>
 * <b>Example 4:</b>
 * <pre>
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * </pre>
 * <b>Example 5:</b>
 * <pre>
 * Input: head = [0,0]
 * Output: 0
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>The Linked List is not empty.</li>
 * <li>Number of nodes will not exceed <tt>30</tt>.</li>
 * <li>Each node's value is either <tt>0</tt> or <tt>1</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 01.11.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getDecimalValue(1, 0, 1));   // 5
        System.out.println(getDecimalValue(0));         // 0
        System.out.println(getDecimalValue(1));         // 1
        System.out.println(getDecimalValue(0, 0));      // 0
    }

    private static int getDecimalValue(int... values) {
        ListNode head = build(values);
        return getDecimalValue(head);
    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = (res << 1) | head.val;
            head = head.next;
        }

        return res;
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
