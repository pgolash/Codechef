package LeetCode.Strings;

import java.util.Arrays;

/**
 * Created by prashantgolash on 9/22/15.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        boolean[][] isPalin = new boolean[s.length() + 1][s.length() + 1];
        int[] DP = new int[s.length() + 1];

        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = -1;

        for (int i = 0; i < s.length(); i++) {
            isPalin[i][i] = true;

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                isPalin[i][j] = isPalin[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (isPalin[j][i - 1]) {
                    DP[i] = Math.min(DP[i], DP[j] + 1);
                }
            }
        }

        return DP[s.length()];
    }
}