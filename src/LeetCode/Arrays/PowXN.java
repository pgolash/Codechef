package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/1/15.
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            double pow = myPow(x, n / 2);
            double ans = pow * pow;
            if (n % 2 != 0) {
                if (n < 0) {
                    return ans * (1 / x);
                } else {
                    return ans * x;
                }
            } else {
                return ans;
            }
        }
    }
}
