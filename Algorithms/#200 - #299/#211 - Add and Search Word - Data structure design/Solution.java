import java.util.Optional;

/**
 * Design a data structure that supports the following two operations:
 * <pre>
 * void addWord(word)
 * bool search(word)
 * </pre>
 * <tt>search(word)</tt> can search a literal word or a regular expression string containing only letters <tt>a-z</tt>
 * or <tt>..</tt> A <tt>.</tt> means it can represent any one letter.
 * <p>
 * <b>Example:</b>
 * <pre>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * </pre>
 * <b>Note:</b>
 * <p>
 * You may assume that all words are consist of lowercase letters <tt>a-z</tt>.
 *
 * @author Oleg Cherednik
 * @since 06.08.2020
 */
public class Solution {

    public static void main(String... args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));  // false
        System.out.println(obj.search("bad"));  // true
        System.out.println(obj.search(".ad"));  // true
        System.out.println(obj.search("b.."));  // true
    }

    public static final class WordDictionary {

        private final Node root = new Node();

        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++)
                node = node.getChild(word.charAt(i));

            node.end = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
         * letter.
         */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private static boolean search(String word, int i, Node parent) {
            if (parent == null)
                return false;
            if (i >= word.length())
                return parent.end;

            char ch = word.charAt(i);

            if (ch == '.') {
                for (Node node : parent.children)
                    if (search(word, i + 1, node))
                        return true;

                return false;
            }

            return search(word, i + 1, parent.children[ch - 'a']);
        }

        private static final class Node {

            private final Node[] children = new Node[26];
            private boolean end;

            public Node getChild(char ch) {
                return children[ch - 'a'] = Optional.ofNullable(children[ch - 'a']).orElseGet(Node::new);
            }
        }
    }
}
