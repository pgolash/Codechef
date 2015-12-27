package LeetCode.Arrays;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1 << 31;
        System.out.println(x);

    }

    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x *= -1;
        }

        // x will be positive
        int maxPow10 = (int)Math.log10(x);
        int minPow10 = 0;
        int extractPow10 = maxPow10;
        long reverseInt = 0;

        while (x > 0) {
            int extract10Num = (int) Math.pow(10, extractPow10);

            int max10Num = (int) Math.pow(10, maxPow10);
            int min10Num = (int) Math.pow(10, minPow10);

            long fNum = x / extract10Num;
            long lNum = x % 10;

            reverseInt += (lNum *  max10Num);
            if (max10Num != min10Num) {
                reverseInt += (fNum * min10Num);
            }

            minPow10++;
            maxPow10--;

            x -= (fNum * extract10Num);
            x /= 10;

            extractPow10 -= 2;
        }

        if (reverseInt > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (neg) {
                return (int) (-1 * reverseInt);
            } else {
                return (int) reverseInt;
            }
        }
    }
}
