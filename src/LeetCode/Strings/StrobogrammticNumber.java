package LeetCode.Strings;

/**
 * Created by prashantgolash on 11/01/16.
 */
public class StrobogrammticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }

        int lo = 0;
        int hi = num.length() - 1;

        while (lo <= hi) {
            if (num.charAt(lo) == num.charAt(hi)) {
                if (isStrobo(num.charAt(lo))) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            } else {
                if ((num.charAt(lo) == '6' && num.charAt(hi) == '9') ||
                        (num.charAt(lo) == '9' && num.charAt(hi) == '6')) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isStrobo(Character num) {
        return num == '0' || num == '1' || num == '8';
    }
}
