import java.util.BitSet;

/**
 * Design a <b>HashSet</b> without using any built-in hash table libraries.
 * <ul>
 * To be specific, your design should include these functions:
 * <li><tt>add(value)</tt>: Insert a value into the <b>HashSet</b>.</li>
 * <li><tt>contains(value)</tt>: Return whether the value exists in the <b>HashSet</b> or not.</li>
 * <li><tt>remove(value)</tt>: Remove a value in the <b>HashSet</b>. If the value does not exist in the <b>HashSet</b>, do nothing.</li>
 * </ul>
 * <b>Example:</b>
 * <pre>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>All values will be in the range of <tt>[0, 1000000]</tt>.</li>
 * <li>The number of operations will be in the range of <tt>[1, 10000]</tt>.</li>
 * <li>Please do not use the built-in HashSet library.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 02.08.2020
 */
public class Solution {

    public static void main(String... args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }

    public static class MyHashSet {

        private static final int MAX_VALUE = 1000000;
        private static final int BUCKET_SIZE = 10000;

        private final BitSet[] buckets = new BitSet[MAX_VALUE / BUCKET_SIZE];

        /** Initialize your data structure here. */
        public MyHashSet() {
        }

        public void add(int key) {
            int bucketId = key / BUCKET_SIZE;

            if (buckets[bucketId] == null)
                buckets[bucketId] = new BitSet(BUCKET_SIZE);

            int value = key % BUCKET_SIZE;
            buckets[bucketId].set(value);
        }

        public void remove(int key) {
            int bucketId = key / BUCKET_SIZE;

            if (buckets[bucketId] == null)
                return;

            int value = key % BUCKET_SIZE;
            buckets[bucketId].clear(value);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int bucketId = key / BUCKET_SIZE;

            if (buckets[bucketId] == null)
                return false;

            int value = key % BUCKET_SIZE;
            return buckets[bucketId].get(value);
        }

    }

}
