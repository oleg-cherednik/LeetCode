/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * <b>Example:</b>
 * <pre>
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = <b>"ABCCED"</b>, return <b>true</b>.
 * Given word = <b>"SEE"</b>, return <b>true</b>.
 * Given word = <b>"ABCB"</b>, return <b>false</b>.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>board</tt> and <tt>word</tt> consists only of lowercase and uppercase English letters.</li>
 * <li><li>1 <= board.length <= 200</li></li>
 * <li><li>1 <= board[i].length <= 200</li></li>
 * <li><li>1 <= word.length <= 10<sup>3</sup></li></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 01.07.2020
 */
public class Solution {

    public static void main(String... args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE"));    // true
        System.out.println(exist(board, "ABCB"));   // false
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++)
                if (exist(row, col, 0, word, board, visited))
                    return true;

        return false;
    }

    private static boolean exist(int row, int col, int i, String word, char[][] board, boolean[][] visited) {
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

        boolean found = exist(row, col + 1, i + 1, word, board, visited);
        found |= exist(row, col - 1, i + 1, word, board, visited);
        found |= exist(row + 1, col, i + 1, word, board, visited);
        found |= exist(row - 1, col, i + 1, word, board, visited);

        if (found)
            return true;

        visited[row][col] = false;
        return false;
    }
}
