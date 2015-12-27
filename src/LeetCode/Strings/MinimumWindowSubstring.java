package LeetCode.Strings;

import LeetCode.Arrays.IntegerToRoman;

import java.nio.charset.CharacterCodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 19/12/15.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("ABC", "ADBC"));
        System.out.println(new MinimumWindowSubstring().minWindow("ABCD", "AD"));
        System.out.println(new MinimumWindowSubstring().minWindow("of_characters_and_as", "aas"));
    }

    public String minWindow(String s, String t) {

        if (s == null || t == null) {
            return "";
        }

        Map<Character, Integer> hasCount = new HashMap<>();
        Map<Character, Integer> toBeFoundCount = new HashMap<>();

        for (Character c : t.toCharArray()) {
            incrementKey(toBeFoundCount, c);
        }

        int sIdx = 0;
        int eIdx = 0;
        int matchCount = 0;
        int minimumWindowLen = Integer.MAX_VALUE;
        int startingIndex = -1;

        while (eIdx < s.length()) {

            Character c = s.charAt(eIdx);
            incrementKey(hasCount, c);

            if (getCount(hasCount, c) <= getCount(toBeFoundCount, c)) {
                matchCount++;
            }

            if (matchCount == t.length()) {
                char sC = s.charAt(sIdx);

                while (getCount(hasCount, sC) > getCount(toBeFoundCount, sC)) {
                    decrementKey(hasCount, sC);
                    sIdx++;
                    sC = s.charAt(sIdx);
                }

                if (eIdx - sIdx < minimumWindowLen) {
                    startingIndex = sIdx;
                    minimumWindowLen = eIdx - sIdx + 1;
                }

                decrementKey(hasCount, sC);
                matchCount--;
                sIdx++;
            }

            eIdx++;
        }

        if (startingIndex != -1) {
            return s.substring(startingIndex, startingIndex + minimumWindowLen);
        } else {
            return "";
        }
    }

    public int getCount(Map<Character, Integer> m, char c) {
        if (m.containsKey(c)) {
            return m.get(c);
        } else {
            return 0;
        }
    }

    public void incrementKey(Map<Character, Integer> m, char c) {
        if (m.containsKey(c)) {
            Integer a = m.get(c);
            m.put(c, a + 1);
        } else {
            m.put(c, 1);
        }
    }

    public void decrementKey(Map<Character, Integer> m, char c) {
        if (m.containsKey(c)) {
            Integer a = m.get(c);
            m.put(c, a - 1);
        }
    }
}
