import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point
 * to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
 * as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 * <img src="multilevellinkedlist.png" />
 * After flattening the multilevel linked list it becomes:
 * <img src="multilevellinkedlistflattened.png" />
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: head = []
 * Output: []
 * </pre>
 * <b>How multilevel linked list is represented in test case:</b>
 * <br>
 * <br>
 * We use the multilevel linked list from <b>Example 1</b> above:
 * <pre>
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * </pre>
 * The serialization of each level is as follows:
 * <pre>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * </pre>
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The
 * serialization becomes:
 * <pre>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * </pre>
 * Merging the serialization of each level and removing trailing nulls we obtain:
 * <pre>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li>Number of Nodes will not exceed <tt>1000</tt>.</li>
 * <li><tt>1 <= Node.val <= 10<sup>5</sup></tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 11.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(flatten(1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12));   // [1,2,3,7,8,11,12,9,10,4,5,6]
        System.out.println(flatten(1, 2, null, 3)); // [1,3,2]
        System.out.println(flatten());              // []
    }

    private static String flatten(Integer... vals) {
        Node head = build(vals);
        head = flatten(head);

        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        return res.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static Node flatten(Node head) {
        return flatten(head, null);
    }

    private static Node flatten(Node head, Node prv) {
        boolean root = prv == null;
        Node res = null;

        while (head != null) {
            Node node = new Node(head.val);
            res = res == null ? node : res;

            if (prv != null) {
                prv.next = node;
                node.prev = prv;
            }

            prv = node;

            if (head.child != null)
                prv = flatten(head.child, prv);

            head = head.next;
        }

        return root ? res : prv;
    }

    private static Node build(Integer... vals) {
        Node head = null;
        Node firstInRow = null;
        Node prv = null;

        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == null) {
                if (prv == null && firstInRow != null)
                    firstInRow = firstInRow.next;
                else
                    prv = null;
            } else {
                Node node = new Node(vals[i]);
                head = i == 0 ? node : head;

                if (firstInRow == null)
                    firstInRow = node;
                else if (prv == null) {
                    firstInRow.child = node;
                    firstInRow = node;
                }

                if (prv != null) {
                    prv.next = node;
                    node.prev = prv;
                }

                prv = node;
            }
        }

        return head;
    }

    public static class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}
