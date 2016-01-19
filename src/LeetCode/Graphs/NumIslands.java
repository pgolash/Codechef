package LeetCode.Graphs;

import java.util.Arrays;

/**
 * Created by prashantgolash on 12/01/16.
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        } else {
            int tC = 0;
            int rLen = grid.length;
            int cLen = grid[0].length;
            boolean[][] visited = new boolean[rLen][cLen];

            for (int i = 0; i < rLen; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < rLen; i++) {
                for (int j = 0; j < cLen; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        tC += 1;
                        swimInIsland(i, j, visited, rLen, cLen, grid);
                    }
                }
            }
            return tC;
        }
    }

    public void swimInIsland(int i, int j, boolean[][] visited, int rLen, int cLen, char[][] grid) {
        if (!visited[i][j]) {
            visited[i][j] = true;
            if (isValidIJ(i + 1, j, rLen, cLen) && grid[i + 1][j] == '1') {
                swimInIsland(i + 1, j, visited, rLen, cLen, grid);
            }
            if (isValidIJ(i - 1, j, rLen, cLen) && grid[i - 1][j] == '1') {
                swimInIsland(i - 1, j, visited, rLen, cLen, grid);
            }
            if (isValidIJ(i, j + 1, rLen, cLen) && grid[i][j + 1] == '1') {
                swimInIsland(i, j + 1, visited, rLen, cLen, grid);
            }
            if (isValidIJ(i, j - 1, rLen, cLen) && grid[i][j - 1] == '1') {
                swimInIsland(i, j - 1, visited, rLen, cLen, grid);
            }
        }
    }

    public boolean isValidIJ(int i, int j, int rLen, int cLen) {
        return !(i >= rLen || j >= cLen || i < 0 || j < 0);
    }

}
