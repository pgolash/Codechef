package LeetCode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class ShortestDistanceII {
    private Map<String, List<Integer>> wordMap = new HashMap<>();
    public ShortestDistanceII(String[] words) {
        for (int idx = 0 ; idx < words.length; idx++) {
            if (wordMap.containsKey(words[idx])) {
                wordMap.get(words[idx]).add(idx);
            } else {
                List<Integer> x = new ArrayList<>();
                x.add(idx);
                wordMap.put(words[idx], x);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if (word1.equals(word2)) {
            List<Integer> l = wordMap.get(word1);
            int prev = l.get(0);
            int diff = Integer.MAX_VALUE;

            for (int i = 1; i < l.size(); i++) {
                diff = Math.max(diff, l.get(i) - prev);
                prev = l.get(i);
            }
            return diff;
        } else {
            int diff = Integer.MAX_VALUE;
            List<Integer> l1 = wordMap.get(word1);
            List<Integer> l2 = wordMap.get(word2);

            int idx1 = 0;
            int idx2 = 0;

            while (idx1 < l1.size() && idx2 < l2.size()) {
                if (l1.get(idx1) > l2.get(idx2)) {
                    diff = Math.min(diff, Math.abs(l1.get(idx1) - l2.get(idx2)));
                    idx2++;
                } else {
                    diff = Math.min(diff, Math.abs(l1.get(idx2) - l2.get(idx1)));
                    idx1++;
                }
            }

            return diff;
        }
    }
}