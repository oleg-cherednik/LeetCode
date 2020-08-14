import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <ol>
 * Design a data structure that supports all following operations in average <b>O(1)</b> time.
 * <li><tt>insert(val)</tt>: Inserts an item val to the set if not already present.</li>
 * <li><tt>remove(val)</tt>: Removes an item val from the set if present.</li>
 * <li><tt>getRandom</tt>: Returns a random element from current set of elements. Each element must have the <b>same probability</b> of being returned.</li>
 * </ol>
 * <b>Example:</b>
 * <pre>
 * {@code
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * }
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 13.06.2020
 */
public class Solution {

    public static void main(String... args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }

    private static class RandomizedSet {

        private final Map<Integer, Integer> map = new HashMap<>();
        private final List<Integer> values = new ArrayList<>();
        private final Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;

            values.add(val);
            map.put(val, values.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                moveToEnd(val);
                removeLast();
                return true;
            }

            return false;
        }

        private void moveToEnd(int val) {
            int lastIndex = values.size() - 1;
            int index = map.get(val);
            int lastVal = values.get(lastIndex);
            map.put(val, lastIndex);
            map.put(lastVal, index);
            values.set(index, lastVal);
            values.set(lastIndex, val);
        }

        private void removeLast() {
            int index = values.size() - 1;
            int val = values.remove(index);
            map.remove(val);
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return map.isEmpty() ? 0 : values.get(random.nextInt(map.size()));
        }
    }


}
