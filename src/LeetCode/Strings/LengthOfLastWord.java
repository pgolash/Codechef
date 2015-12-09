package LeetCode.Strings;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String t = s.trim();
        int idx = t.length() - 1;
        int cnt = 0;

        while (idx >= 0 && t.charAt(idx) != ' ') {
            idx--;
            cnt++;
        }

        return cnt;
    }
}
