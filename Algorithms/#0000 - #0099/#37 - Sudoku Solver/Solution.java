import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * <ol>
 * A sudoku solution must satisfy <b>all of the following rules</b>:
 * <li>Each of the digits 1-9 must occur exactly once in each row.</li>
 * <li>Each of the digits 1-9 must occur exactly once in each column.</li>
 * <li>Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.</li>
 * </ol>
 * The <tt>'.'</tt> character indicates empty cells.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img src="250px-Sudoku-by-L2G-20050714.svg.png" />
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
 * Output:
 * [
 *   ["5","3","4","6","7","8","9","1","2"],
 *   ["6","7","2","1","9","5","3","4","8"],
 *   ["1","9","8","3","4","2","5","6","7"],
 *   ["8","5","9","7","6","1","4","2","3"],
 *   ["4","2","6","8","5","3","7","9","1"],
 *   ["7","1","3","9","2","4","8","5","6"],
 *   ["9","6","1","5","3","7","2","8","4"],
 *   ["2","8","7","4","1","9","6","3","5"],
 *   ["3","4","5","2","8","6","1","7","9"]
 * ]
 * </pre>
 * Explanation: The input board is shown above and the only valid solution is shown below:
 * <p>
 * <img src="Sudoku-by-L2G-20050714_solution.svg.png" />
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>board.length == 9</tt></li>
 * <li><tt>board[i].length == 9</tt></li>
 * <li><tt>board[i][j] is a digit or '.'.</tt></li>
 * <li>It is <b>guaranteed</b> that the input board has only one solution.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 21.08.2025
 */
public class Solution {

    public static void main(String... args) {
        /*
            534678912
            672195348
            198342567
            859761423
            426853791
            713924856
            961537284
            287419635
            345286179
        */
        System.out.println(getSolvedSudoku(new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

        /*
            519748632
            783652419
            426139875
            357986241
            264317598
            198524367
            975863124
            832491756
            641275983
         */
        System.out.println(getSolvedSudoku(new char[][] {
                { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
                { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
                { '.', '.', '7', '.', '.', '.', '2', '4', '.' },
                { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
                { '.', '9', '8', '.', '.', '.', '3', '.', '.' },
                { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '6' },
                { '.', '.', '.', '2', '7', '5', '9', '.', '.' } }));
    }

    private static String getSolvedSudoku(char[][] board) {
        solveSudoku(board);
        return toString(board);
    }

    private static String toString(char[][] board) {
        StringBuilder buf = new StringBuilder();

        for (int row = 0; row < board.length; row++) {
            if (row > 0)
                buf.append('\n');
            for (int col = 0; col < board.length; col++)
                buf.append(board[row][col]);
        }

        return buf.append('\n').toString();
    }

    public static void solveSudoku(char[][] board) {
        List<Cell> unfixed = markSingleCellsAsFixed(board, createCells(board));
        dfs(new Board(board, unfixed), 0);
    }

    private static List<Cell> markSingleCellsAsFixed(char[][] board, List<Cell> cells) {
        boolean hasMore = true;
        List<Cell> tmp = new ArrayList<>();

        while (hasMore) {
            hasMore = false;

            for (Cell cell : cells) {
                if (cell.candidates.size() == 1) {
                    int value = cell.candidates.iterator().next();

                    board[cell.row.num][cell.col.num] = (char) ('0' + value);

                    cell.markFixed(value);
                    cell.row.markFixed(cell);
                    cell.col.markFixed(cell);
                    cell.subBox.markFixed(cell);

                    hasMore = true;
                } else
                    tmp.add(cell);
            }

            cells.clear();
            cells.addAll(tmp);
            tmp.clear();
        }

        return cells;
    }

    private static boolean markSingleCellsAsFixed(Board board) {
        boolean hasMore = true;
        List<Cell> tmp = new ArrayList<>();

        while (hasMore) {
            hasMore = false;

            for (Cell cell : board.unfixed) {
                if (cell.fixed) {
                    if (!cell.row.markFixed(cell) || !cell.col.markFixed(cell) || !cell.subBox.markFixed(cell))
                        return false;

                    hasMore = true;
                } else if (cell.candidates.size() == 1) {
                    int value = cell.candidates.iterator().next();
                    board.board[cell.row.num][cell.col.num] = (char) ('0' + value);
                    cell.markFixed(value);

                    if (!cell.row.markFixed(cell)
                            || !cell.col.markFixed(cell)
                            || !cell.subBox.markFixed(cell))
                        return false;

                    hasMore = true;
                } else
                    tmp.add(cell);
            }

            board.unfixed.clear();
            board.unfixed.addAll(tmp);
            tmp.clear();
        }

        return true;
    }

    private static boolean dfs(Board board, int snapshotId) {
        if (board.unfixed.isEmpty())
            return true;

        board.unfixed.sort(Cell.SORT_BY_CANDIDATES_AMOUNT.thenComparing(Cell.SORT_BY_SUB_BOX_EMPTY_CELL_AMOUNT));

        for (Cell cell : new ArrayList<>(board.unfixed)) {
            if (cell.fixed)
                continue;

            for (int candidate : new HashSet<>(cell.candidates)) {
                board.board[cell.row.num][cell.col.num] = '*';
                board.snapshot(snapshotId);
                board.board[cell.row.num][cell.col.num] = (char) ('0' + candidate);

                cell.markFixed(candidate);

                int amount = board.unfixed.size();
                boolean success = markSingleCellsAsFixed(board);

                if (!success || board.unfixed.size() == amount) {
                    board.board[cell.row.num][cell.col.num] = '.';
                    board.restoreSnapshot(snapshotId);
                    cell.unmarkedFixed();
                } else if (dfs(board, snapshotId + 1))
                    return true;
                else {
                    cell.unmarkedFixed();
                    board.restoreSnapshot(snapshotId);
                    board.board[cell.row.num][cell.col.num] = '.';
                }
            }

            return false;
        }

        return false;
    }

    private static List<Cell> createCells(char[][] board) {
        List<Cell> cells = new ArrayList<>(9 * 9);
        List<Data> rows = IntStream.range(0, 9)
                                   .mapToObj(row -> new Data("row", row))
                                   .collect(Collectors.toList());
        List<Data> cols = IntStream.range(0, 9)
                                   .mapToObj(col -> new Data("col", col))
                                   .collect(Collectors.toList());
        List<Data> subBoxes = IntStream.range(0, 9)
                                       .mapToObj(num -> new Data("subBox", num))
                                       .collect(Collectors.toList());

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != '.') {
                    int value = board[row][col] - '0';
                    rows.get(row).values.add(value);
                    cols.get(col).values.add(value);
                    subBoxes.get(Cell.subBoxId(row, col)).values.add(value);
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != '.')
                    continue;

                Data r = rows.get(row);
                Data c = cols.get(col);
                Data sb = subBoxes.get(Cell.subBoxId(row, col));

                Set<Integer> candidates = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toSet());
                candidates.removeAll(r.values);
                candidates.removeAll(c.values);
                candidates.removeAll(sb.values);

                Cell cell = new Cell(r, c, sb, candidates);
                cells.add(cell);
                r.cells.add(cell);
                c.cells.add(cell);
                sb.cells.add(cell);
            }
        }

        return cells;
    }

    private static final class Cell {

        public static final Comparator<Cell> SORT_BY_CANDIDATES_AMOUNT =
                Comparator.comparingInt(cell -> cell.candidates.size());
        public static final Comparator<Cell> SORT_BY_SUB_BOX_EMPTY_CELL_AMOUNT =
                Comparator.comparingInt(cell -> cell.subBox.emptyCellsAmount());

        private final Data row;
        private final Data col;
        private final Data subBox;
        private final Set<Integer> candidates;
        private final Map<Integer, Set<Integer>> candidateSnapshots = new HashMap<>();
        private final Map<Integer, Integer> valueSnapshots = new HashMap<>();
        private int value;
        private boolean fixed;

        private Cell(Data row, Data col, Data subBox, Set<Integer> candidates) {
            this.row = row;
            this.col = col;
            this.subBox = subBox;
            this.candidates = new HashSet<>(candidates);
        }

        public void snapshot(int id) {
            candidateSnapshots.put(id, new HashSet<>(candidates));
            valueSnapshots.put(id, value);

            row.snapshot(id);
            col.snapshot(id);
            subBox.snapshot(id);
        }

        public void restoreSnapshot(int id) {
            if (candidateSnapshots.containsKey(id)) {
                candidates.clear();
                candidates.addAll(candidateSnapshots.remove(id));
            }

            if (valueSnapshots.containsKey(id)) {
                value = valueSnapshots.remove(id);
                fixed = value > 0;
            }

            row.restoreSnapshot(id);
            col.restoreSnapshot(id);
            subBox.restoreSnapshot(id);
        }

        public void markFixed(int candidate) {
            fixed = true;
            value = candidate;
        }

        public void unmarkedFixed() {
            fixed = false;
            value = 0;
        }

        public String toString() {
            return String.format("[%d:%d] %s", row.num, col.num, fixed ? String.valueOf(value) : candidates);
        }

        public static int subBoxId(int row, int col) {
            if (row < 3) {
                if (col < 3)
                    return 0;
                return col < 6 ? 1 : 2;
            } else if (row < 6) {
                if (col < 3)
                    return 3;
                return col < 6 ? 4 : 5;
            } else {
                if (col < 3)
                    return 6;
                return col < 6 ? 7 : 8;
            }
        }
    }

    private static final class Data {

        private final String id;
        private final int num;
        private final Set<Integer> values = new HashSet<>();
        private final Set<Cell> cells = new HashSet<>();
        private final Map<Integer, Set<Integer>> valueSnapshots = new HashMap<>();
        private final Map<Integer, Set<Cell>> cellSnapshots = new HashMap<>();

        public Data(String id, int num) {
            this.id = id;
            this.num = num;
        }

        public void snapshot(int id) {
            valueSnapshots.put(id, new HashSet<>(values));
            cellSnapshots.put(id, new HashSet<>(cells));
        }

        public void restoreSnapshot(int id) {
            if (valueSnapshots.containsKey(id)) {
                values.clear();
                values.addAll(valueSnapshots.remove(id));
            }

            if (cellSnapshots.containsKey(id)) {
                cells.clear();
                cells.addAll(cellSnapshots.remove(id));
            }
        }

        public int emptyCellsAmount() {
            return 9 - values.size();
        }

        public boolean markFixed(Cell cell) {
            cells.remove(cell);

            if (!values.add(cell.value))
                return true;

            for (Cell c : cells) {
                if (c.fixed)
                    continue;

                c.candidates.remove(cell.value);

                if (c.candidates.isEmpty())
                    return false;
            }

            return true;
        }

        public String toString() {
            return String.format("[%s:%d] %s%s", id, num, values, values.size() == 9 ? " - fixed" : "");
        }

    }

    private static final class Board {

        private final char[][] board;
        private final List<Cell> unfixed;
        private final Map<Integer, List<Cell>> snapshots = new HashMap<>();

        public Board(char[][] board, List<Cell> unfixed) {
            this.board = board;
            this.unfixed = unfixed;
        }

        public void snapshot(int id) {
            snapshots.put(id, new ArrayList<>(unfixed));
            unfixed.forEach(cell -> cell.snapshot(id));
        }

        public void restoreSnapshot(int id) {
            if (!snapshots.containsKey(id))
                return;

            unfixed.clear();
            unfixed.addAll(snapshots.remove(id));
            unfixed.forEach(cell -> cell.restoreSnapshot(id));
        }
    }

}

