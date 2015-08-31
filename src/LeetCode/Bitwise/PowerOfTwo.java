package LeetCode.Bitwise;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else {
            return ((n & (n-1)) == 0);
        }
    }
}