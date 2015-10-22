package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> l = new GenerateParenthesis().generateParenthesis(2);
        for (String s : l) {
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();
        generateParenthesis(n, 0, 0, "", l);
        return l;
    }

    public void generateParenthesis(int n, int open, int close, String s, List<String> answer) {
        if (open == n && close == n) {
            answer.add(s);
        } else {
            StringBuilder bld = new StringBuilder(s);
            if (open < n) {
                bld.append('(');
                generateParenthesis(n, open + 1, close, bld.toString(), answer);
                bld.deleteCharAt(bld.length() - 1);
            }

            if (close < open && close < n) {
                bld.append(')');
                generateParenthesis(n, open, close + 1, bld.toString(), answer);
            }
        }
    }
}
