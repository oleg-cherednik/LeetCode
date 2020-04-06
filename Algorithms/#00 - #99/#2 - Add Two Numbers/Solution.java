import java.math.BigInteger;

/**
 * You are given two <b>non-empty</b> linked lists representing two non-negative integers. The digits are stored in <b>reverse order</b> and each of
 * their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <b>Example:</b>
 * <pre>
 * <b>Input:</b> (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <b>Output:</b> 7 -> 0 -> 8
 * <b>Explanation:</b> 342 + 465 = 807.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 26.08.2018
 */
public class Solution {
    public static void main(String... args) {
        ListNode l1 = toList(BigInteger.valueOf(342));
        ListNode l2 = toList(BigInteger.valueOf(465));
        System.out.println(toNumber(addTwoNumbers(l1, l2)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toList(toNumber(l1).add(toNumber(l2)));
    }

    private static BigInteger toNumber(ListNode node) {
        StringBuilder buf = new StringBuilder();

        while (node != null) {
            buf.append(node.val);
            node = node.next;
        }

        return new BigInteger(buf.reverse().toString());
    }

    private static ListNode toList(BigInteger val) {
        String str = val.toString();
        ListNode res = null;

        for (int i = 0; i < str.length(); i++) {
            ListNode node = new ListNode(str.charAt(i) - '0');
            node.next = res;
            res = node;
        }

        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
