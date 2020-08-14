import java.util.Arrays;

/**
 * Given a 2D board containing <tt>'X'</tt> and <tt>'O'</tt> (<b>the letter O</b>), capture all regions surrounded by <tt>'X'</tt>.
 * <p>
 * A region is captured by flipping all <tt>'O'</tt>s into <tt>'X'</tt>s in that surrounded region.
 * <p>
 * <b>Example:</b>
 * <pre>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * </pre>
 * After running your function, the board should be:
 * <pre>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 * <b>Explanation:</b>
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any <tt>'O'</tt> on the border of the board are not flipped to <tt>'X'</tt>. Any
 * <tt>'O'</tt> that is not on the border and it is not connected to an <tt>'O'</tt> on the border will be flipped to <tt>'X'</tt>. Two cells are
 * connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author Oleg Cherednik
 * @since 17.06.2020
 */
public class Solution {

    public static void main(String... args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };

        solve(board);

        StringBuilder buf = new StringBuilder();
        buf.append('[');

        for (int row = 0; row < board.length; row++) {
            if (buf.length() > 1)
                buf.append(',');
            buf.append(Arrays.toString(board[row]));
        }

        System.out.println(buf.toString()); // [[X, X, X, X],[X, X, X, X],[X, X, X, X],[X, O, X, X]
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        mark(board, 'O', '-');
        markNotSurrounded(board, '-', 'O');
        mark(board, '-', 'X');
    }

    private static void markNotSurrounded(char[][] board, char src, char dest) {
        for (int col = 0; col < board[0].length; col++) {
            dfs(board, 0, col, src, dest);
            dfs(board, board.length - 1, col, src, dest);
        }

        for (int row = 0; row < board.length; row++) {
            dfs(board, row, 0, src, dest);
            dfs(board, row, board[0].length - 1, src, dest);
        }
    }

    private static void mark(char[][] board, char src, char dest) {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (board[row][col] == src)
                    board[row][col] = dest;
    }

    private static void dfs(char[][] board, int row, int col, char src, char dest) {
        if (row < 0 || row >= board.length)
            return;
        if (col < 0 || col >= board[row].length)
            return;
        if (board[row][col] != src)
            return;

        board[row][col] = dest;
        dfs(board, row, col + 1, src, dest);
        dfs(board, row, col - 1, src, dest);
        dfs(board, row + 1, col, src, dest);
        dfs(board, row - 1, col, src, dest);
    }

}
