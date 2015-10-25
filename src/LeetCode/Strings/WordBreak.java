package LeetCode.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by prashantgolash on 10/4/15.
 */
public class WordBreak {

    public static void main(String[] args) {
        Set<String> x = new HashSet<>();
        x.add("leet");
        x.add("code");

        System.out.println(new WordBreak().wordBreak("leetcode", x));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] DP = new boolean[s.length() + 1];
        Arrays.fill(DP, false);

        DP[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = DP[i] || DP[j - 1] && wordDict.contains(s.substring(j - 1, i));
            }
        }

        return DP[s.length()];
    }
}
