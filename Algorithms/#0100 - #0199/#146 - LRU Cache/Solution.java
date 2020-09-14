import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for <a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU">Least Recently Used (LRU)
 * cache</a>. It should support the following operations: <tt>get</tt> and <tt>put</tt>.
 * <p>
 * <tt>get(key)</tt> - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return <tt>-1.</tt>
 * <p>
 * <tt>put(key, value)</tt> - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the
 * least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a <b>positive</b> capacity.
 * <p>
 * <b>Follow up:</b>
 * <p>
 * Could you do both operations in <b>O(1)</b> time complexity?
 * <p>
 * <b>Example:</b>
 * <pre>
 * LRUCache cache = new LRUCache(2); // capacity
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);     // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);     // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 24.04.2020
 */

public class Solution {

    public static void main(String... args) {
        one();
        two();
    }

    private static void one() {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        System.out.println();
    }

    private static void two() {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));   // -1
        cache.put(2, 6);
        System.out.println(cache.get(1));   // -1
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));   // 2
        System.out.println(cache.get(2));   // 6

        System.out.println();
    }

    public static class LRUCache {

        private final Map<Integer, LinkedList.Node> map = new HashMap<>();
        private final LinkedList linkedList = new LinkedList();
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            LinkedList.Node node = map.get(key);

            if (node == null)
                return -1;

            linkedList.moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            LinkedList.Node node = map.get(key);

            if (map.size() == capacity && node == null) {
                LinkedList.Node removedNode = linkedList.removeTail();

                if (removedNode != null)
                    map.remove(removedNode.key);
            } else
                linkedList.remove(node);

            map.put(key, linkedList.addToHead(key, value));
        }

        private static final class LinkedList {

            private Node head;
            private Node tail;

            public Node addToHead(int key, int value) {
                return addToHead(new Node(key, value));
            }

            private Node addToHead(Node node) {
                if (head == null) {
                    head = node;
                    tail = node;
                } else if (head.next == null) {
                    node.next = head;
                    head.prev = node;
                    head = node;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }

                return node;
            }

            public Node removeTail() {
                if (tail == null)
                    return null;

                Node node;

                if (tail == head) {
                    node = tail;
                    head = null;
                    tail = null;
                } else {
                    node = tail;
                    Node preTail = tail.prev;
                    preTail.next = null;
                    tail.prev = null;
                    tail = preTail;
                }

                return node;
            }

            public void moveToHead(Node node) {
                remove(node);
                addToHead(node);
            }

            public void remove(Node node) {
                if (head == null || node == null)
                    return;

                if (head == tail && head == node) {
                    head = null;
                    tail = null;
                } else if (head == node) {
                    Node next = node.next;
                    node.next = null;
                    next.prev = null;
                    head = next;
                } else if (tail == node) {
                    Node prev = node.prev;
                    node.prev = null;
                    prev.next = null;
                    tail = prev;
                } else {
                    Node prev = node.prev;
                    Node next = node.next;

                    prev.next = next;
                    next.prev = prev;

                    node.prev = null;
                    node.next = null;
                }
            }

            public static final class Node {

                private final int key;
                private final int val;
                private Node prev;
                private Node next;

                public Node(int key, int val) {
                    this.key = key;
                    this.val = val;
                }
            }
        }

    }
}
