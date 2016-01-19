package GeeksForGeeks.Tree;

import java.util.Stack;

/**
 * Created by prashantgolash on 05/01/16.
 */
public class DepthTree {
    public static int getTreeDepth(String inp) {

        if(inp == null) {
            return -1;
        }

        if(inp.length() < 4) {
            return -1;
        }

        if(inp.charAt(0) != '(' || inp.charAt(inp.length() -1) != ')') {
            return -1;
        }

        int depth = -1;
        int zeroCount = 0;
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<inp.length(); i++) {
            char c = inp.charAt(i);
            if(c == '(') {
                stack.push(c);
                if(stack.size() > depth) {
                    depth = stack.size();
                }
                zeroCount = 0;
            } else if(c == ')') {
                stack.pop();
                zeroCount = 0;
            } else {
                if( c != '0') {
                    return -1;
                } else {
                    zeroCount += 1;
                    if(zeroCount > 2) {
                        return -1;
                    }
                }
            }
        }

// invalid pattern

        if(stack.size() > 0) {
            return -1;
        }

        return depth-1;
    }
}
