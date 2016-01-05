package LeetCode.Tree;

import java.util.Stack;

/**
 * Created by prashantgolash on 04/01/16.
 */
public class VerifyPreOrderSequence {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
}
