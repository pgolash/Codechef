package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1807", "7810"));
    }

    public String getHint(String secret, String guess) {
        Map<Character, Integer> s = new HashMap<>();
        Map<Character, Integer> g = new HashMap<>();
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s1 = secret.charAt(i);
            char g1 = guess.charAt(i);
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (s.containsKey(s1)) {
                    Integer a = s.get(s1);
                    s.put(s1, a + 1);
                } else {
                    s.put(s1, 1);
                }

                if (g.containsKey(g1)) {
                    Integer a = g.get(g1);
                    g.put(g1, a + 1);
                } else {
                    g.put(g1, 1);
                }
            }
        }

        for (Character c : s.keySet()) {
            if (g.containsKey(c)) {
                cows += Math.min(g.get(c), s.get(c));
            }
        }

        StringBuilder bld = new StringBuilder();
        bld.append(bulls);
        bld.append('A');
        bld.append(cows);
        bld.append('B');

        return bld.toString();

    }
}
