package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/01/16.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        } else {
            int x1 = 1;
            int x2 = 1;

            for (int i = 2; i <= n; i++) {
                int temp = x2 * (k - 1);
                if (i == 2) {
                    temp += x1;
                } else {
                    temp += x1 * (k - 1);
                }
                x1 = x2;
                x2 = temp;
            }

            return x2 * k;
        }
    }
}