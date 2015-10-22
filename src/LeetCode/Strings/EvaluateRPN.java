package LeetCode.Strings;

import java.util.Stack;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class EvaluateRPN {

    public static void main(String[] args) {
        String[] str = new String[] {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateRPN().evalRPN(str));

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> myS = new Stack<>();
        int val;

        for (String s: tokens) {
            if (isValidOperator(s)) {
                int i2 = myS.pop();
                int i1 = myS.pop();
                val = getValue(i1, i2, s);
                myS.push(val);
            } else {
                myS.push(getInteger(s));
            }
        }

        return myS.pop();
    }

    public boolean isValidOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    public int getValue(int val1, int val2, String oper) {
        if (oper.equals("+")) {
            return val1 + val2;
        } else if (oper.equals("-")) {
            return val1 - val2;
        } else if (oper.equals("*")) {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public int getInteger(String s) {
        return Integer.parseInt(s);
    }
}
