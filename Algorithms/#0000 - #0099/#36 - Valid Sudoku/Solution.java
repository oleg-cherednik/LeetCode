import java.util.Arrays;

/**
 * <ol>
 * Determine if a <tt>9x9</tt> Sudoku board is valid. Only the filled cells need to be validated <b>according to the
 * following rules:</b>
 * <li>Each row must contain the digits <tt>1-9</tt> without repetition.</li>
 * <li>Each column must contain the digits <tt>1-9</tt> without repetition.</li>
 * <li>Each of the <tt>9 3x3</tt> sub-boxes of the grid must contain the digits <tt>1-9</tt> without repetition.</li>
 * </ol>
 * <p>
 * <img src="250px-Sudoku-by-L2G-20050714.svg" />
 * <sub>A partially filled sudoku which is valid.</sub>
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character <tt>'.'</tt>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * </pre>
 * <ul>
 * <b>Note:</b>
 * <li>A Sudoku board (partially filled) could be valid but is not necessarily solvable.</li>
 * <li>Only the filled cells need to be validated according to the mentioned rules.</li>
 * <li>The given board contain only digits <tt>1-9</tt> and the character <tt>'.'</tt>.</li>
 * <li>The given board size is always <tt>9x9</tt>.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 21.08.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isValidSudoku(new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));    // true
        System.out.println(isValidSudoku(new char[][] {
                { '8', '3', '.', '.', '.', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));    // false
        System.out.println(isValidSudoku(new char[][] {
                { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '9', '3', '.', '.', '2', '.', '4', '.', '.' },
                { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '5', '2', '.', '.' } }));    // false
    }

    public static boolean isValidSudoku(char[][] board) {
        int size = board.length;
        return isRowsValid(board, size)
                && isColsValid(board, size)
                && isSubBoxesValid(board, size);
    }

    private static boolean isRowsValid(char[][] board, int size) {
        boolean[] exist = new boolean[size + 1];

        for (int row = 0; row < size; row++) {
            Arrays.fill(exist, false);

            for (int col = 0; col < size; col++) {
                char ch = board[row][col];

                if (ch == '.')
                    continue;

                int pos = ch - '0';

                if (exist[pos])
                    return false;

                exist[pos] = true;
            }
        }

        return true;
    }

    private static boolean isColsValid(char[][] board, int size) {
        boolean[] exist = new boolean[size + 1];

        for (int col = 0; col < size; col++) {
            Arrays.fill(exist, false);

            for (int row = 0; row < size; row++) {
                char ch = board[row][col];

                if (ch == '.')
                    continue;

                int pos = ch - '0';

                if (exist[pos])
                    return false;

                exist[pos] = true;
            }
        }

        return true;
    }

    private static boolean isSubBoxesValid(char[][] board, int size) {
        boolean[] exist = new boolean[size + 1];

        for (int row = 0; row + 3 <= size; row += 3) {
            for (int col = 0; col + 3 <= size; col += 3) {
                Arrays.fill(exist, false);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char ch = board[row + i][col + j];

                        if (ch == '.')
                            continue;

                        int pos = ch - '0';

                        if (exist[pos])
                            return false;

                        exist[pos] = true;
                    }
                }
            }
        }

        return true;
    }

}

