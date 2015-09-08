package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by pgolash on 9/8/2015.
 */
public class UniquePaths {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] DP = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            DP[i][1] = 1;
        }

        for (int j = 1; j <= n; j++) {
            DP[1][j] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
            }
        }

        return DP[m][n];


    }
}
