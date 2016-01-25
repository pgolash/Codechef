package LeetCode.Arrays;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(28));
    }

    public boolean isPowerOfThree(int n) {
        double x = Math.log10(n) / Math.log10(3);
        return x - (int)x == 0;
    }
}