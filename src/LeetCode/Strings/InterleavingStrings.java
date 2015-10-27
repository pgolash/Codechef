package LeetCode.Strings;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class InterleavingStrings {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";

        String s3 = "aadbbbaccc";

        System.out.println(new InterleavingStrings().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null) {
            return s3 == null;
        } else if(s1.length() + s2.length() != s3.length()) {
            return false;
        } else {
            boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];

            for (int i = 0; i <= s1.length(); i++) {
                Arrays.fill(DP[i], false);
            }

            DP[0][0] = true;

            for (int i = 1; i <= s1.length(); i++) {
                DP[i][0] = DP[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            }

            for (int j = 1; j <= s2.length(); j++) {
                DP[0][j] = DP[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
            }

            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                        DP[i][j] = DP[i - 1][j];
                    }
                    if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                        DP[i][j] = DP[i][j] || DP[i][j - 1];
                    }

                }
            }
            return DP[s1.length()][s2.length()];
        }
    }
}