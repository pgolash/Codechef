package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {

        Map<Character, Integer> p = new HashMap<>();
        Map<String, Integer> s = new HashMap<>();
        StringBuilder pBld = new StringBuilder();
        StringBuilder sBld = new StringBuilder();

        int idx = 0;
        for (char c : pattern.toCharArray()) {
            if (p.containsKey(c)) {
                pBld.append(p.get(c));
            } else {
                pBld.append(idx);
                p.put(c, idx);
            }
            idx++;
        }

        String[] words = str.split(" ");
        idx = 0;
        for (String word : words) {
            if (s.containsKey(word)) {
                sBld.append(s.get(word));
            } else {
                sBld.append(idx);
                s.put(word, idx);
            }
            idx++;
        }

        return pBld.toString().equals(sBld.toString());
    }
}
