package LeetCode.Strings;

import java.util.Arrays;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int pointer = 0;
        boolean invalid = false;
        while(pointer < strs[0].length()) {
            char c = strs[0].charAt(pointer);
            for (int i = 1; i < strs.length; i++) {
                if (pointer < strs[i].length() && strs[i].charAt(pointer) == c) {
                    continue;
                } else {
                    invalid = true;
                    break;
                }
            }
            if (invalid) {
                break;
            } else {
                pointer++;
            }
        }

        return strs[0].substring(0, pointer);
    }
}
