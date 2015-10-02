package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class NumZeroes {
    public int trailingZeroes(int n) {
        int num = 0;
        int cnt = -1;
        long currNum = 5;
        while (cnt != 0) {
            cnt = (int) (n / currNum);
            num += cnt;
            currNum *= 5;
        }

        return num;
    }
}
