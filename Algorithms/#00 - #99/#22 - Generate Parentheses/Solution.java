import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given <tt>n = 3</tt>, a solution set is:
 * <pre>
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 23.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(generateParenthesis(1)); // [()]
        System.out.println(generateParenthesis(2)); // [(()), ()()]
        System.out.println(generateParenthesis(3)); // [((())), (()()), (())(), ()(()), ()()()]
    }

    public static List<String> generateParenthesis(int n) {
        return generateParenthesis("", 0, 0, n, new LinkedList<>());
    }

    private static List<String> generateParenthesis(String str, int open, int count, int n, List<String> res) {
        if (count == 0 && str.length() == n * 2)
            res.add(str);
        else {
            if (open < n)
                generateParenthesis(str + '(', open + 1, count + 1, n, res);
            if (count > 0)
                generateParenthesis(str + ')', open, count - 1, n, res);
        }

        return res;
    }

}

