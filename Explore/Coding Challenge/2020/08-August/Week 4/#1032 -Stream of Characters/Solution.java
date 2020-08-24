/**
 * <ul>
 * Implement the <tt>StreamChecker</tt> class as follows:
 * <li><tt>StreamChecker(words)</tt>: Constructor, init the data structure with the given words.</li>
 * <li><tt>query(letter)</tt>: returns true if and only if for some <tt>k >= 1</tt>, the last <tt>k</tt> characters queried (in order from oldest to
 * newest, including this letter just queried) spell one of the words in the given list.</li>
 * </ul>
 * <p>
 * <b>Example:</b>
 * <pre>
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li><tt>1 <= words.length <= 2000</tt></li>
 * <li><tt>1 <= words[i].length <= 2000</tt></li>
 * <li>Words will only consist of lowercase English letters.</li>
 * <li>Queries will only consist of lowercase English letters.</li>
 * <li>The number of queries is at most 40000.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 23.08.2020
 */
public class Solution {

    public static void main(String... args) {
        StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" });
        System.out.println(streamChecker.query('a'));   // false
        System.out.println(streamChecker.query('b'));   // false
        System.out.println(streamChecker.query('c'));   // false
        System.out.println(streamChecker.query('d'));   // true
        System.out.println(streamChecker.query('e'));   // false
        System.out.println(streamChecker.query('f'));   // true
        System.out.println(streamChecker.query('g'));   // false
        System.out.println(streamChecker.query('h'));   // false
        System.out.println(streamChecker.query('i'));   // false
        System.out.println(streamChecker.query('j'));   // false
        System.out.println(streamChecker.query('k'));   // false
        System.out.println(streamChecker.query('l'));   // true
    }

    static class StreamChecker {

        private final TreeNode root = new TreeNode();
        private final StringBuilder buf = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words) {
                TreeNode node = root;

                for (int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);

                    if (node.letters[ch - 'a'] == null)
                        node.letters[ch - 'a'] = new TreeNode();

                    node = node.letters[ch - 'a'];
                }

                node.word = true;
            }
        }

        public boolean query(char letter) {
            buf.append(letter);
            TreeNode node = root;

            for (int i = buf.length() - 1; i >= 0 && node != null; i--) {
                node = node.letters[buf.charAt(i) - 'a'];

                if (node != null && node.word)
                    return true;
            }

            return false;
        }

        private static final class TreeNode {

            private final TreeNode[] letters = new TreeNode[26];
            private boolean word;
        }

    }

}
