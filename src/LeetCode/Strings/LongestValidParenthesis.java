package LeetCode.Strings;

/**
 * Created by prashantgolash on 26/01/16.
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }

            int[] dp = new int[s.length()];
            int maxLen = 0;

            for (int i = s.length() - 2; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    int j = i + dp[i + 1] + 1;
                    if (j < s.length() && s.charAt(j) == ')') {
                        dp[i] = dp[i + 1] + 2;
                        if (j + 1 < s.length()) {
                            dp[i] += dp[j + 1];
                        }
                    }
                }

                maxLen = Math.max(maxLen, dp[i]);
            }

            return maxLen;
        }
}
