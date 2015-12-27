package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sM = new HashMap<>();
        Map<Character, Integer> tM = new HashMap<>();
        StringBuilder bld1 = new StringBuilder();
        StringBuilder bld2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (sM.containsKey(s.charAt(i))) {
                bld1.append(sM.get(s.charAt(i)));
            } else {
                sM.put(s.charAt(i), i);
                bld1.append(i);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            if (tM.containsKey(t.charAt(j))) {
                bld2.append(tM.get(t.charAt(j)));
            } else {
                tM.put(t.charAt(j), j);
                bld2.append(j);
            }
        }

        return bld1.toString().equals(bld2.toString());

    }
}
