import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Implement a trie with <tt>insert</tt>, <tt>search</tt>, and <tt>startsWith</tt> methods.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>You may assume that all inputs are consist of lowercase letters <tt>a-z</tt>.</li>
 * <li>All inputs are guaranteed to be non-empty strings.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.05.2019
 */
public class Solution {

    public static void main(String... args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }

    private static class Trie {

        private final Map<String, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;

            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);

                if (i == word.length())
                    map.compute(prefix, (key, count) -> Optional.ofNullable(count).orElse(0) + 1);
                else
                    map.putIfAbsent(prefix, 0);
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return map.getOrDefault(word, 0) > 0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return map.containsKey(prefix);
        }
    }
}
