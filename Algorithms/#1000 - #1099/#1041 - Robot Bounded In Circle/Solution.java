import java.util.function.Consumer;

/**
 * <ul>
 * On an infinite plane, a robot initially stands at <tt>(0, 0)</tt> and faces north. The robot can receive one of three instructions:
 * <li><tt>"G"</tt>: go straight 1 unit;</li>
 * <li><tt>"L"</tt>: turn 90 degrees to the left;</li>
 * <li><tt>"R"</tt>: turn 90 degress to the right.</li>
 * </ul>
 * The robot performs the <tt>instructions</tt> given in order, and repeats them forever.
 * <p>
 * Return <tt>true</tt> if and only if there exists a circle in the plane such that the robot never leaves the circle.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 * </pre>
 * <ol>
 * <b>Note:</b>
 * <li><tt>1 <= instructions.length <= 100</tt></li>
 * <li><tt>instructions[i] is in {'G', 'L', 'R'}</tt></li>
 * </ol>
 *
 * @author Oleg Cherednik
 * @since 19.09.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isRobotBounded("GGLLGG"));   // true
        System.out.println(isRobotBounded("GG"));       // false
        System.out.println(isRobotBounded("GL"));       // true
    }

    public static boolean isRobotBounded(String instructions) {
        Position position = new Position();
        Direction direction = Direction.NORTH;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                char ch = instructions.charAt(j);

                if (ch == 'G')
                    direction.move.accept(position);
                else if (ch == 'L')
                    direction = direction.turnLeft();
                else if (ch == 'R')
                    direction = direction.turnRight();
            }

            if (position.x == 0 && position.y == 0 && direction == Direction.NORTH)
                return true;
        }

        return false;
    }

    private static final class Position {

        private int x;
        private int y;

    }

    private enum Direction {
        EAST(position -> position.x++),
        WEST(position -> position.x--),
        NORTH(position -> position.y++),
        SOUTH(position -> position.y--);

        private final Consumer<Position> move;

        Direction(Consumer<Position> move) {
            this.move = move;
        }

        public final Direction turnLeft() {
            if (this == EAST)
                return NORTH;
            if (this == WEST)
                return SOUTH;
            if (this == NORTH)
                return WEST;
            return EAST;
        }

        public final Direction turnRight() {
            if (this == EAST)
                return SOUTH;
            if (this == WEST)
                return NORTH;
            if (this == NORTH)
                return EAST;
            return WEST;
        }
    }

}
