import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all <tt>words</tt> in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li>All inputs are consist of lowercase letters <tt>a-z</tt>.</li>
 * <li>The values of <tt>words</tt> are distinct.</li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 01.07.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findWords(new char[][] {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();

        for (String word : words) {
            for (boolean[] row : visited)
                Arrays.fill(row, false);

            boolean found = false;

            for (int row = 0; row < board.length && !found; row++)
                for (int col = 0; col < board[0].length && !found; col++)
                    found = findWord(row, col, 0, word, board, visited);

            if (found)
                res.add(word);
        }

        return res;
    }

    private static boolean findWord(int row, int col, int i, String word, char[][] board, boolean[][] visited) {
        if (i >= word.length())
            return true;
        if (row < 0 || row >= board.length)
            return false;
        if (col < 0 || col >= board[row].length)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != word.charAt(i))
            return false;

        visited[row][col] = true;

        boolean found = findWord(row, col + 1, i + 1, word, board, visited);
        found |= findWord(row, col - 1, i + 1, word, board, visited);
        found |= findWord(row + 1, col, i + 1, word, board, visited);
        found |= findWord(row - 1, col, i + 1, word, board, visited);

        if (found)
            return true;

        visited[row][col] = false;
        return false;
    }
}
