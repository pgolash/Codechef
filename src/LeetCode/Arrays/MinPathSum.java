package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/1/15.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        } else {
            int rowLength = grid.length;
            int colLength = grid[0].length;

            for (int i = 1; i < rowLength; i++) {
                grid[i][0] += grid[i - 1][0];
            }

            for (int j = 1; j < colLength; j++) {
                grid[0][j] += grid[0][j - 1];
            }

            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < colLength; j++) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }

            return grid[rowLength - 1][colLength - 1];
        }
    }
}
