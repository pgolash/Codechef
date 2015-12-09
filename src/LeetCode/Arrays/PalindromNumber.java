package LeetCode.Arrays;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class PalindromNumber {

    public static void main(String[] args) {
        System.out.println(new PalindromNumber().isPalindrome(1));
        System.out.println(new PalindromNumber().isPalindrome(132));
        System.out.println(new PalindromNumber().isPalindrome(1000032));
        System.out.println(new PalindromNumber().isPalindrome(1000021));
        System.out.println(new PalindromNumber().isPalindrome(1331));
        System.out.println(new PalindromNumber().isPalindrome(13331));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int max10Pow = (int) Math.log10((double)x);
            boolean flag = true;
            int mul10 = (int) Math.pow(10, max10Pow);

            while ((max10Pow >= 1) && flag) {
                int firstDigit =  x / mul10;
                int lastDigit = x % 10;
                flag = (firstDigit == lastDigit);

                x -= (firstDigit * mul10);
                x /= 10;

                mul10 /= 100;
                max10Pow -= 2;
            }
            return flag;
        }
    }
}
