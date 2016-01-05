package LeetCode.Strings;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class ShorestDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (!word1.equals(word2)) {
            return shortestDistanceDiff(words, word1, word2);
        } else {
            boolean flag = true;
            int idx1 = -1;
            int idx2 = -1;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (flag) {
                        idx1 = i;
                        if (idx2 != -1) {
                            diff = Math.min(diff, idx1 - idx2);
                        }
                    } else {
                        idx2 = i;
                        diff = Math.min(diff, idx2 - idx1);
                    }
                    flag = !flag;
                }
            }
            return diff;
        }
    }

    public int shortestDistanceDiff(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int diff = Integer.MAX_VALUE;

        for (int idx = 0; idx < words.length; idx++) {
            if (words[idx].equals(word1)) {
                if (idx1 < idx2) {
                    // no need to compare both of them
                    // just update idx1
                    diff = Math.min(diff, idx - idx2);
                }
                idx1 = idx;
            } else if (words[idx].equals(word2)) {
                if (idx2 < idx1) {
                    // no need to compare both of them
                    // just update idx1
                    diff = Math.min(diff, idx - idx1);
                }
                idx2 = idx;
            }
        }

        return diff;

    }

}
