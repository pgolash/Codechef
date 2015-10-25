package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays w = new DecodeWays();
        System.out.println(w.numDecodings("12"));
        System.out.println(w.numDecodings("10"));
        System.out.println(w.numDecodings("100"));
        System.out.println(w.numDecodings("001"));
        System.out.println(w.numDecodings("123"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return isValidChar(s.charAt(0)) ? 1 : 0;
        } else {
            int curr = 0;
            int prev1 = isValidChar(s.charAt(0)) ? 1 : 0;
            int prev2 = 1;
            for (int idx = 1; idx < s.length(); idx++) {
                curr = 0;
                if (isValidChar(s.charAt(idx))) {
                    curr += prev1;
                }
                if (isValidChar(s.charAt(idx - 1), s.charAt(idx))) {
                    curr += prev2;
                }
                int temp = prev1;
                prev1 = curr;
                prev2 = temp;
            }
            return curr;
        }
    }

    public boolean isValidChar(char a) {
        return a >='1' && a <= '9';
    }

    public boolean isValidChar(char a, char b) {
        if (a == '0') {
            return false;
        } else {
            int aInt = a - '0';
            int bInt = b - '0';
            return aInt * 10 + bInt >= 10 && aInt * 10 + bInt <= 26;
        }
    }
}