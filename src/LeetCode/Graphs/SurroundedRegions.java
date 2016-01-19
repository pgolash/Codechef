package LeetCode.Graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by prashantgolash on 17/01/16.
 */
public class SurroundedRegions {

    class Data {
        int x;
        int y;

        Data (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        } else {

            LinkedList<Data> lD = new LinkedList<>();
            int rLen = board.length;
            int cLen = board[0].length;

            boolean[][] visited = new boolean[rLen][cLen];

            for (int i = 0; i < rLen; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int j = 0; j < cLen; j++) {
                if (board[0][j] == 'O') {
                    visited[0][j] = true;
                    lD.add(new Data(0, j));
                }

                if (board[rLen - 1][j] == 'O') {
                    visited[rLen - 1][j] = true;
                    lD.add(new Data(rLen - 1, j));
                }
            }

            for (int i = 0; i < rLen; i++) {
                if (board[i][0] == 'O') {
                    visited[i][0] = true;
                    lD.add(new Data(i, 0));
                }

                if (board[i][cLen - 1] == 'O') {
                    visited[i][cLen - 1] = true;
                    lD.add(new Data(i, cLen - 1));
                }
            }

            while (!lD.isEmpty()) {
                Data d = lD.pop();
                if (d.x + 1 < rLen && board[d.x + 1][d.y] == '0' && !visited[d.x + 1][d.y]) {
                    visited[d.x + 1][d.y] = true;
                    lD.add(new Data(d.x + 1, d.y));
                }

                if (d.y + 1 < cLen && board[d.x][d.y + 1] == '0' && !visited[d.x][d.y + 1]) {
                    visited[d.x][d.y + 1] = true;
                    lD.add(new Data(d.x, d.y + 1));
                }

                if (d.x - 1 >= 0 && board[d.x - 1][d.y] == '0' && !visited[d.x - 1][d.y]) {
                    visited[d.x - 1][d.y] = true;
                    lD.add(new Data(d.x - 1, d.y));
                }

                if (d.y - 1 >= 0 && board[d.x][d.y - 1] == '0' && !visited[d.x][d.y - 1]) {
                    visited[d.x][d.y - 1] = true;
                    lD.add(new Data(d.x, d.y - 1));
                }
            }

            for (int i = 0; i < rLen; i++) {
                for (int j = 0; j < cLen; j++) {
                    if (board[i][j] == '0' & !visited[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
