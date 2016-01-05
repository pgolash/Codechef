package LeetCode.Strings;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class Atoi {


    public int myAtoi(String str) {
        boolean foundSign = false;
        boolean neg = false;
        boolean conversionPerformed = false;
        boolean maxReached = false;

        int sIdx = 0;
        long num = 0;

        while (sIdx < str.length()) {
            if (foundSign) {
                // get Number
                while (sIdx < str.length() && Character.isDigit(str.charAt(sIdx))) {
                    conversionPerformed = true;
                    num = num * 10 + Character.getNumericValue(str.charAt(sIdx));
                    if (num > Integer.MAX_VALUE) {
                        maxReached = true;
                        break;
                    }
                    sIdx++;
                }
                break;
            } else {
                if (Character.isWhitespace(str.charAt(sIdx))) {
                    sIdx++;
                    continue;
                } else if (Character.isDigit(str.charAt(sIdx))) {
                    conversionPerformed = true;
                    num = num * 10 + Character.getNumericValue(str.charAt(sIdx));
                    foundSign = true;
                } else if (str.charAt(sIdx) == '+' || str.charAt(sIdx) == '-') {
                    foundSign = true;
                    neg = str.charAt(sIdx) == '+' ? false: true;
                } else {
                    break;
                }
            }
            sIdx++;
        }

        if (conversionPerformed) {
            if (neg) {
                if (maxReached) {
                    return Integer.MIN_VALUE;
                } else {
                    return (int) (-1 * num);
                }
            } else {
                if (maxReached) {
                    return Integer.MAX_VALUE;
                } else {
                    return (int) (num);
                }
            }
        } else {
            return 0;
        }
    }
}