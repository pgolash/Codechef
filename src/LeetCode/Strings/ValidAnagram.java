package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (t == null) {
            return false;
        } else {
            boolean flag = true;
            Map<Character, Integer> charMap = new HashMap<>();

            for (char c : s.toCharArray()) {
                if (charMap.containsKey(c)) {
                    Integer cnt = charMap.get(c);
                    charMap.put(c, cnt + 1);
                } else {
                    charMap.put(c, 1);
                }
            }

            for (char c : t.toCharArray()) {
                if (charMap.containsKey(c)) {
                    Integer cnt = charMap.get(c);
                    cnt--;
                    if (cnt == 0) {
                        charMap.remove(c);
                    } else {
                        charMap.put(c, cnt);
                    }
                } else {
                    flag = false;
                    break;
                }
            }

            flag = flag && charMap.isEmpty();
            return flag;
        }
    }
}
