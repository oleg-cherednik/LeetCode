/**
 * <ul>
 * Design an Iterator class, which has:
 * <li>A constructor that takes a string <tt>characters</tt> of <b>sorted distinct</b> lowercase English letters and a number <tt>combinationLength</tt>
 * as arguments.</li>
 * <li>A function <tt>next()</tt> that returns the next combination of length <tt>combinationLength</tt> in <b>lexicographical order</b>.</li>
 * <li>A function <tt>hasNext()</tt> that returns <tt>True</tt> if and only if there exists a next combination.</li>
 * </ul>
 * <p>
 * <b>Example:</b>
 * <pre>
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 *
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= combinationLength <= characters.length <= 15</tt></li>
 * <li>There will be at most 10<sup>4</sup> function calls per test.</li>
 * <li>It's guaranteed that all calls of the function <tt>next</tt> are valid.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 14.08.2020
 */
public class Solution {

    public static void main(String... args) {
        CombinationIterator it = new CombinationIterator("abc", 2);

        while (it.hasNext())
            System.out.println(it.next());  // ab, ac, bc
    }

    public static class CombinationIterator {

        private final int[] index;
        private final String characters;

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            index = new int[combinationLength];

            for (int i = 0; i < index.length; i++)
                index[i] = i;
        }

        public String next() {
            if (!hasNext())
                return null;

            int len = characters.length();

            StringBuilder buf = new StringBuilder();

            for (int i = 0; i < index.length; i++)
                buf.append(characters.charAt(index[i]));

            // increment the index to point to next valid combination
            int inc = 1;
            int stk = 0;

            for (int i = index.length - 1; i >= 0; i--, stk++, inc++) {
                if (index[i] >= len - inc)
                    continue;

                index[i]++;
                break;
            }

            if (stk > 0)
                for (int j = index.length - stk; j < index.length; j++)
                    index[j] = j - 1 >= 0 ? index[j - 1] + 1 : index[j] + 1;

            return buf.toString();
        }

        public boolean hasNext() {
            int len = characters.length();

            for (int i = index.length - 1; i >= 0; i--)
                if (index[i] >= len--)
                    return false;

            return true;
        }
    }
}
