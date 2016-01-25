package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 20/01/16.
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        if (str == null || str.length() == 0) {
            return pattern == null || pattern.length() == 0;
        }

        if (pattern == null || pattern.length() == 0) {
            return str == null || str.length() == 0;
        }

        int len = pattern.length();

        Map<String, Character> map = new HashMap<>();
        Map<Character, String> invertedMap = new HashMap<>();

        return wordPatternMatchHelper(0, 0, pattern, str, map, invertedMap);
    }

    private boolean wordPatternMatchHelper(int start, int seg, String pattern,
                                           String str,
                                           Map<String, Character> map,
                                           Map<Character, String> invertedMap) {
        if (start == str.length() && seg == pattern.length()) {
            return true;
        }

        if (start >= str.length() || seg >= pattern.length()) {
            return false;
        }

        char c = pattern.charAt(seg);
        for (int i = start; i < str.length(); i++) {
            String substr = str.substring(start, i + 1);

            if (map.containsKey(substr) &&
                    invertedMap.containsKey(c) &&
                    map.get(substr) == c &&
                    invertedMap.get(c).equals(substr)) {
                if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                        str, map, invertedMap)) {
                    return true;
                }
            }

            if (!map.containsKey(substr) && !invertedMap.containsKey(c)) {
                map.put(substr, c);
                invertedMap.put(c, substr);

                if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                        str, map, invertedMap)) {
                    return true;
                }

                map.remove(substr);
                invertedMap.remove(c);
            }
        }

        return false;
    }
}
