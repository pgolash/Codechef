package LeetCode.Strings;

import java.util.Stack;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("8 – ( 5 – ( 7 + 6 ) )"));

    }


    public int calculate(String s) {
            Stack<Integer> stack = new Stack<Integer>(); //store the signs for the '('
            stack.push(1); //invisible '+' before the (whole string)
            int res = 0;
            int sign = 1; //the operator before num (default: '+')
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+' || c == '-') {
                    sign = c == '+' ? 1 : -1;
                } else if (c == '(') {
                    stack.push(stack.peek() * sign); //stack.peek() is the sign before the enclosing '()' of this '('; sign : the operator before this '(';
                    sign = 1; //default sign = '+' for a digit right after a '('
                } else if (c == ')') {
                    stack.pop();
                } else if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    i--;
                    res += stack.peek() * sign * num; //stack.peek() is the sign before the enclosing '()' of this num; sign : the operator before num;
                }
            }
            return res;
        }
    }
