package LeetCode.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n < 1) return false;

        Set<Integer> set = new HashSet<Integer>();
        while (n != 1 && ! set.contains(n)) {
            set.add(n);
            n = nextLoop(n);
        }

        return n==1;
    }

    private int nextLoop(int n) {
        int result = 0;
        while (n!=0) {
            int d = n % 10;
            result += d * d;
            n /= 10;
        }

        return result;
    }
}
