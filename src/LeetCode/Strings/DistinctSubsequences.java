package LeetCode.Strings;

import sun.security.util.DisabledAlgorithmConstraints;
import sun.tools.jconsole.AboutDialog;

import java.util.Arrays;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        int s = new DistinctSubsequences().numDistinct("ddd", "dd");
        System.out.println(s);
    }

    public int numDistinct(String s, String t) {

        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int numRows = t.length();
        int numCols = s.length();

        int[][] DP = new int[numRows][numCols];

        for(int i = 0; i < numRows; i++) {
            Arrays.fill(DP[i], 0);
        }

        if (s.charAt(0) == t.charAt(0)) {
            DP[0][0] = 1;
        }

        for (int j = 1; j < numCols; j++) {
            if (s.charAt(j) == t.charAt(0)) {
                DP[0][j] = DP[0][j - 1] + 1;
            }
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    DP[i][j] = DP[i][j - 1] + DP[i - 1][j - 1];
                } else {
                    DP[i][j] = DP[i][j - 1];
                }
            }
        }

        return DP[numRows - 1][numCols - 1];
    }
}
