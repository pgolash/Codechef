package LeetCode.Graphs;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class GameOfLife {
    int getLiveNeighbors(int[][] board, int m, int n, int i, int j){
        int cnt = 0;
        if(i-1>=0 && board[i-1][j]%2==1) cnt++;
        if(i+1<m  && board[i+1][j]%2==1) cnt++;
        if(j-1>=0 && board[i][j-1]%2==1) cnt++;
        if(j+1<n  && board[i][j+1]%2==1) cnt++;

        if(i-1>=0 && j-1>=0 && board[i-1][j-1]%2==1) cnt++;
        if(i-1>=0 && j+1<n  && board[i-1][j+1]%2==1) cnt++;
        if(i+1<m  && j-1>=0 && board[i+1][j-1]%2==1) cnt++;
        if(i+1<m  && j+1<n  && board[i+1][j+1]%2==1) cnt++;
        return cnt;
    }
    void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int nl = getLiveNeighbors(board, m, n, i, j);
                if(board[i][j]==1 && (nl<2||nl>3)) board[i][j] = 3;
                else if(board[i][j]==0 && nl==3) board[i][j] = 2;
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j]==3) board[i][j] = 0;
                if(board[i][j]==2) board[i][j] = 1;
            }
        }
    }
}
