/**
 * The demons had captured the princess (<b>P</b>) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of <tt>M x N</tt>
 * rooms laid out in a 2D grid. Our valiant knight (<b>K</b>) was initially positioned in the top-left room and must fight his way through the
 * dungeon
 * to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies
 * immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (<i>negative integers</i>) upon entering these rooms; other rooms are either
 * empty (<i>0's</i>) or contain magic orbs that increase the knight's health (<i>positive integers</i>).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * <b>Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.</b>
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least <b>7</b> if he follows the optimal path <tt>RIGHT-> RIGHT
 * -> DOWN -> DOWN</tt>.
 * <p>
 * <img src="dungeon.png" />
 * <ul>
 * <b>Note:</b>
 * <li>The knight's health has no upper bound.</li>
 * <li>Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 22.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(calculateMinimumHP(new int[][] {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 } }));  // 7
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] health = new int[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (row == rows - 1 && col == cols - 1)
                    health[row][col] = Math.max(1 - dungeon[row][col], 1);
                else if (row == rows - 1)
                    health[row][col] = Math.max(health[row][col + 1] - dungeon[row][col], 1);
                else if (col == cols - 1)
                    health[row][col] = Math.max(health[row + 1][col] - dungeon[row][col], 1);
                else {
                    int right = Math.max(health[row][col + 1] - dungeon[row][col], 1);
                    int down = Math.max(health[row + 1][col] - dungeon[row][col], 1);
                    health[row][col] = Math.min(right, down);
                }
            }
        }

        return health[0][0];
    }

}
