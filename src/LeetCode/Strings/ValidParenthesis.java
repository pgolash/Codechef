package LeetCode.Strings;

import java.util.Stack;

/**
 * Created by prashantgolash on 9/29/15.
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else {
            Stack<Character> stk = new Stack<>();
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stk.push(c);
                } else {
                    if (!stk.empty()) {
                        isValid = isCorrectClosing(c, stk.pop());
                    } else {
                        isValid = false;
                    }
                }
                if (!isValid) {
                    break;
                }
            }

            isValid = isValid && stk.empty();
            return isValid;
        }
    }

    public boolean isCorrectClosing(char c1, char c2) {
        if (c1 == ')') {
            return c2 == '(';
        } else if (c1 == ']') {
            return c2 == '[';
        } else if (c1 == '}'){
            return c2 == '{';
        } else {
            return false;
        }
    }
}
