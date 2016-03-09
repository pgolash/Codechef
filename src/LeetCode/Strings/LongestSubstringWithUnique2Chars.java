package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 25/01/16.
 */
public class LongestSubstringWithUnique2Chars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 3) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int j = 0;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            if (!map.containsKey(element)) {
                counter++;
                map.put(element, 1);

                while (j < i && counter > 2) {
                    if (map.get(s.charAt(j)) == 1) {
                        map.remove(s.charAt(j));
                    } else {
                        int tmp = map.get(s.charAt(j)) - 1;
                        map.put(s.charAt(j), tmp);
                    }

                    if (!map.containsKey(s.charAt(j))) {
                        counter--;
                    }
                    j++;
                }
            } else {
                int tmp = map.get(s.charAt(i));
                map.put(s.charAt(i), tmp + 1);
            }

            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;

    }
}
