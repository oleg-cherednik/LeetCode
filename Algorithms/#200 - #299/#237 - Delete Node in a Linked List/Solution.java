import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- <tt>head = [4,5,1,9]</tt>, which looks like following:
 * <p>
 * <img src="237_example.png" />
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>The linked list will have at least two elements.</li>
 * <li>All of the nodes' values will be unique.</li>
 * <li>The given node will not be the tail and it will always be a valid node of the linked list.</li>
 * <li>Do not return anything from your function.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(deleteNode(new int[] { 4, 5, 1, 9 }, 5));    // [4,1,9]
        System.out.println(deleteNode(new int[] { 4, 5, 1, 9 }, 1));    // [4,5,9]
    }

    private static String deleteNode(int[] values, int val) {
        ListNode root = build(values);
        ListNode node = root;

        while (node.val != val)
            node = node.next;

        deleteNode(node);

        List<Integer> res = new ArrayList<>();

        while (root != null) {
            res.add(root.val);
            root = root.next;
        }

        return res.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
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
