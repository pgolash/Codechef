package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 05/01/16.
 */
public class GeneratePossibleMoves {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> x = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return x;
        } else {
            StringBuilder bld = new StringBuilder(s);
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                    bld.setCharAt(i, '-');
                    bld.setCharAt(i + 1, '-');
                    x.add(bld.toString());
                    bld.setCharAt(i, '+');
                    bld.setCharAt(i + 1, '+');
                }
                if (s.charAt(i) == '-' && s.charAt(i + 1) == '-') {
                    bld.setCharAt(i, '+');
                    bld.setCharAt(i + 1, '+');
                    x.add(bld.toString());
                    bld.setCharAt(i, '-');
                    bld.setCharAt(i + 1, '-');
                }
            }
            return x;
        }
    }
}
