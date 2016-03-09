package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/13/15.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {

            if (dungeon == null) {
                return 0;
            }

            int m = dungeon.length;
            int n = dungeon[0].length;

            int[][] dp = new int[m][n];

            dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

            // Initialization the last column
            for (int i = m - 2; i >= 0; i--) {
                dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
            }

            // Initialization the last row
            for (int i = n - 2; i >= 0; i--) {
                dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j],
                            dp[i][j + 1]) - dungeon[i][j]);
                }
            }

            return dp[0][0];
        }

}
