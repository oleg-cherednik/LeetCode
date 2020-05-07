/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <img src="160_statement.png" />
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="160_example_1.png" />
 * <pre>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as
 * [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the
 * intersected node in B.
 * </pre>
 * <b>Example 2:</b>
 * <p></p>
 * <img src="160_example_2.png" />
 * <pre>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as
 * [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected
 * node in B.
 * </pre>
 * <b>Example 3:</b>
 * <p>
 * <img src="160_example_3.png" />
 * <pre>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect,
 * intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * </pre>
 * <ul>
 * <b>Notes:</b>
 * <li>If the two linked lists have no intersection at all, return <tt>null</tt>.</li>
 * <li>The linked lists must retain their original structure after the function returns.</li>
 * <li>You may assume there are no cycles anywhere in the entire linked structure.</li>
 * <li>Your code should preferably run in <tt>O(n)</tt> time and use only <tt>O(1)</tt> memory.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 06.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getIntersectionNode(new int[] { 4, 1, 8, 4, 5 }, new int[] { 5, 0, 1 }, 2)); // 8
        System.out.println(getIntersectionNode(new int[] { 0, 9, 1, 2, 4 }, new int[] { 3 }, 3));       // 2
        System.out.println(getIntersectionNode(new int[] { 2, 6, 4 }, new int[] { 1, 5 }, -1));         // null
    }

    private static Integer getIntersectionNode(int[] listA, int[] listB, int offs) {
        ListNode headA = build(listA);
        ListNode headB = build(listB);
        link(headA, headB, offs);
        ListNode res = getIntersectionNode(headA, headB);
        return res == null ? null : res.val;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++)
                headA = headA.next;
        } else if (sizeA < sizeB) {
            for (int i = 0; i < sizeB - sizeA; i++)
                headB = headB.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static ListNode build(int... values) {
        ListNode head = null;
        ListNode prv = null;

        for (int val : values) {
            ListNode node = new ListNode(val);

            if (head == null)
                head = node;
            else
                prv.next = node;

            prv = node;
        }

        return head;
    }

    private static void link(ListNode headA, ListNode headB, int offs) {
        if (offs < 0)
            return;

        for (int i = 0; i < offs; i++)
            headA = headA.next;

        while (headB.next != null)
            headB = headB.next;

        headB.next = headA;
    }

    private static int getSize(ListNode node) {
        int size = 0;

        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
