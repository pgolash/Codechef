package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prashantgolash on 9/3/15.
 */
public class IterativePostOrderTraversal {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    class StackObject {
        TreeNode pointer;
        boolean rightPresent;
        StackObject(TreeNode pointer, boolean rightPresent) {
            this.pointer = pointer;
            this.rightPresent = rightPresent;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<StackObject> myStack = new Stack<>();
        List<Integer> myL = new ArrayList<>();
        boolean isDone = false;

        while (!isDone) {

            if (root == null) {
                if (!myStack.empty()) {
                    if (myStack.peek().rightPresent) {
                        myStack.peek().rightPresent = false;
                        root = myStack.peek().pointer.right;
                    } else {
                        myL.add(myStack.pop().pointer.val);
                    }
                } else {
                    isDone = true;
                }
            } else {

                if (root.right != null) {
                    myStack.push(new StackObject(root, true));
                } else {
                    myStack.push(new StackObject(root, false));
                }

                root = root.left;
            }
        }

        return myL;

    }
}
