/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: 1->2
 * Output: false
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: 1->2->2->1
 * Output: true
 * </pre>
 * <b>Follow up:</b>
 * <p>
 * Could you do it in <tt>O(n)</tt> time and <tt>O(1)</tt> space?
 *
 * @author Oleg Cherednik
 * @since 03.04.2019
 */
public class Solution {

    public static void main(String... args) {
        isPalindrome(1, 2);         // false
        isPalindrome(1, 2, 2, 1);   // true
    }

    private static void isPalindrome(int... values) {
        System.out.println(isPalindrome(build(values)));
    }

    public static boolean isPalindrome(ListNode head) {
        return isPalindromeUtil(new ListNode[] { head, null }, head);
    }

    private static final int HEAD = 0;
    private static final int LEFT = 1;

    private static boolean isPalindromeUtil(ListNode[] nodes, ListNode right) {
        nodes[LEFT] = nodes[HEAD];

        if (right == null)
            return true;
        if (!isPalindromeUtil(nodes, right.next))
            return false;

        boolean isp1 = right.val == nodes[LEFT].val;
        nodes[LEFT] = nodes[LEFT].next;

        return isp1;
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
