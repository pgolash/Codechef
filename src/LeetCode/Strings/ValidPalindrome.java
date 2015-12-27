package LeetCode.Strings;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else {
            int sIdx = 0;
            int eIdx = s.length() - 1;
            boolean palin = true;

            while (sIdx < eIdx) {
                while (sIdx < eIdx && !isValid(s.charAt(sIdx))) {
                    sIdx++;
                }

                while (sIdx < eIdx && !isValid(s.charAt(eIdx))) {
                    eIdx--;
                }

                if (sIdx < eIdx) {
                    if (Character.toLowerCase(s.charAt(sIdx)) != Character.toLowerCase(s.charAt(eIdx))) {
                        palin = false;
                        break;
                    }
                }
                sIdx++;
                eIdx--;
            }
            return palin;
        }
    }

    public boolean isValid(Character c) {
        boolean lowerCase = c >= 'a' && c <= 'z';
        boolean upperCase = c >= 'A' && c <= 'Z';
        boolean numeric = c >= '0' && c <= '9';
        return lowerCase || upperCase || numeric;
    }
}
