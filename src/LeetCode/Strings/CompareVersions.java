package LeetCode.Strings;

/**
 * Created by prashantgolash on 9/29/15.
 */
public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        int vers1Int = getInteger(version1);
        int vers2Int = getInteger(version2);

        int vers1Decimal = getDecimal(version1);
        int vers2Decimal = getDecimal(version2);

        if (vers1Int > vers2Int) {
            return 1;
        } else if (vers1Int == vers2Int) {
            if (vers1Decimal > vers2Decimal) {
                return 1;
            } else if (vers1Decimal == vers2Decimal) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int getInteger(String s) {
        int num = 0;
        int idx = 0;

        while (idx < s.length() && s.charAt(idx) != '.') {
            int digit = s.charAt(idx) - 48;
            num = num * 10 + digit;
            idx++;
        }

        return num;
    }

    public int getDecimal(String s) {
        int num = 0;
        int idx = 0;

        while (idx < s.length() && s.charAt(idx) != '.') {
            idx++;
        }

        idx++;

        while(idx < s.length()) {
            int digit = s.charAt(idx) - 48;
            num = num * 10 + digit;
            idx++;
        }

        return num;
    }
}
