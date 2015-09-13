package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/7/15.
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return n;
        } else {
            int[] DP = new int[n + 1];
            DP[1] = 1;
            DP[2] = 2;

            for (int i = 3; i <= n; i++) {
                DP[i] = DP[i - 1] + DP[i - 2];
            }

            return DP[n];
        }
    }
}
