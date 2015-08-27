package LeetCode.Arrays;

/**
 * Created by prashant on 8/26/2015.
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;

    }
}
