package LeetCode.Arrays;

/**
 * Created by prashantgolash on 13/01/16.
 */
public class NumberOfOnes {

    public static void main(String[] args) {
        NumberOfOnes on = new NumberOfOnes();
        System.out.println(on.countDigitOne(11));
    }

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 9) {
            return 1;
        } else if (isPowerOf10(n)) {
            return 1 + countDigitOne(n - 1);
        } else {
            int hPowerOf10 = (int) Math.log10(n);
            int power = (int) Math.pow(10, hPowerOf10);
            int y = countDigitOne(power);
            int frontDigit = n / power;

            int z = 0;

            if (frontDigit == 1) {
                z = y;
                z += n - power;
            } else {
                z = frontDigit * (y - 1);
                z += power;
            }

            return z + countDigitOne(n -  frontDigit * power);
        }
    }

    public boolean isPowerOf10(int n) {
        double x = Math.log10(n);
        return (x - (int)x) == 0.0;
    }
}
