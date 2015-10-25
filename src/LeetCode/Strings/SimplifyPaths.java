package LeetCode.Strings;

import java.util.Stack;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class SimplifyPaths {
    public static void main(String[] args) {
        String s = "/...";
        System.out.println(new SimplifyPaths().simplifyPath("/..."));
    }

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> myStack = new Stack<String>();

        if (tokens.length == 0) {
            return "/";
        }


        for (String str : tokens) {
            if (str.equals("")) {
                continue;
            } else {
                if (str.equals(".")) {
                    // do nothing
                } else if (str.equals("..")) {
                    if (!myStack.empty()) {
                        myStack.pop();
                    }
                } else {
                    myStack.push(str);
                }
            }
        }

        StringBuilder bld = new StringBuilder();

        while (!myStack.empty()) {
            bld.append("/");
            bld.append(myStack.pop());
        }

        if (bld.toString().equals("")) {
            return "/";
        } else {
            return bld.toString();
        }

    }
}
