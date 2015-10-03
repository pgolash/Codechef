package LeetCode.Strings;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] isPalin = new boolean[s.length() + 1][s.length() + 1];
        int maxPalinLen = Integer.MIN_VALUE;
        String minPalin = null;

        for (int i = 0; i < s.length(); i++) {
            isPalin[i][i] = true;
            maxPalinLen = 1;
            minPalin = s.substring(i, i + 1);

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                isPalin[i][i + 1] = true;
                maxPalinLen = 1;
                minPalin = s.substring(i, i + 2);
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                isPalin[i][j] = isPalin[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalin[i][j] && (j - i + 1 > maxPalinLen)) {
                    maxPalinLen = j - i + 1;
                    minPalin = s.substring(i, j + 1);
                }
            }
        }

        return minPalin;

    }
}
