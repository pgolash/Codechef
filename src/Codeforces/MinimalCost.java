package Codeforces;

/**
 * Created by prashantgolash on 26/03/16.
 */
public class MinimalCost {
    public static void main(String[] args) {
        String[] w1 = {".4...1", "4.1...", ".1.1..", "..1.1.", "...1.1", "1...1."};
        String[] w2 = {".4...1", "4.1...", ".1.1..", "..1.1.", "...1.1", "1...1."};
        System.out.println(new MinimalCost().minimalCost(w1, w2));
    }

    public int minimalCost(String[] weight1, String[] weight2) {
        int n = weight1.length;
        int maxW2 = 180;

        int[][][] dp = new int[n][n][maxW2 + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int w2 = 0; w2 <= maxW2; w2++) {
                    dp[i][j][w2] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (weight1[i].charAt(j) != '.') {
                    int w2 = weight2[i].charAt(j) - '0';
                    dp[i][j][w2] = weight1[i].charAt(j) - '0';
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int w2 = 1; w2 <= maxW2; w2++) {
                        for (int x = 1; x < w2; x++) {
                            if (dp[i][k][x] != Integer.MAX_VALUE && dp[k][j][w2 - x] != Integer.MAX_VALUE) {
                                dp[i][j][w2] = Math.min(dp[i][j][w2], dp[i][k][x] + dp[k][j][w2 - x]);
                            }
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int w2 = 1; w2 <= maxW2; w2++) {
            if (dp[0][1][w2] != Integer.MAX_VALUE) {
                if (ans > dp[0][1][w2] * w2) {
                    ans = dp[0][1][w2] * w2;
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        return ans;
    }
}
