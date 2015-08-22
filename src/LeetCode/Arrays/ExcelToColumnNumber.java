package LeetCode.Arrays;

/**
 * Created by prashantgolash on 8/22/15.
 */
public class ExcelToColumnNumber {
    public static void main(String[] args) {

    }

    public int titleToNumber(String s) {
        int finVal = 0;

        for (int i = 1; i <= s.length(); i++) {
            int prod = (int) Math.pow(26, s.length() - i);
            int charValue = s.charAt(i - 1) - 'A' + 1;
            finVal += prod * charValue;
        }

        return finVal;

    }
}
