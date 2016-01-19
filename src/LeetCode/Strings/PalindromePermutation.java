package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 05/01/16.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else {

            Map<Character, Integer> m = new HashMap<>();
            for (Character c : s.toCharArray()) {
                if (m.containsKey(c)) {
                    Integer x = m.get(c);
                    m.put(c, x + 1);
                } else {
                    m.put(c, 1);
                }
            }

            boolean oddOccured = false;
            boolean isPalin = true;

            for (Character c : m.keySet()) {
                if (m.get(c) % 2 != 0) {
                    if (oddOccured) {
                        isPalin = false;
                        break;
                    } else {
                        oddOccured = true;
                    }
                }
            }

            return isPalin;
        }
    }
}
