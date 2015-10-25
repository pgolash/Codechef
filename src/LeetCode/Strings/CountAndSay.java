package LeetCode.Strings;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder x = new StringBuilder("1");
        for (int idx = 2; idx <= n; idx++) {
            StringBuilder bld = new StringBuilder();
            int sIdx = 0;
            while (sIdx < x.length()) {
                char c = x.charAt(sIdx++);
                int cnt = 1;
                while (sIdx < x.length() && x.charAt(sIdx) == c) {
                    sIdx++;
                    cnt++;
                }

                bld.append(cnt);
                bld.append(c);
            }
            x = bld;
        }
        return x.toString();
    }
}
