package LeetCode.Tree;

import java.util.*;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answerL = new ArrayList<List<Integer>>();
        if (root == null) {
            return answerL;
        } else {
            boolean left = true;
            Stack<TreeNode> stk = new Stack<>();
            stk.push(root);
            while (!stk.isEmpty()) {
                Stack<TreeNode> tempStk = new Stack<>();
                List<Integer> l = new ArrayList<>();
                while (!stk.isEmpty()) {
                    TreeNode node = stk.pop();
                    if (left) {
                        if (node.left != null) {
                            tempStk.push(node.left);
                        }
                        if (node.right != null) {
                            tempStk.push(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            tempStk.push(node.right);
                        }
                        if (node.left != null) {
                            tempStk.push(node.left);
                        }
                    }
                    l.add(node.val);
                }
                left = !left;
                stk = tempStk;
                answerL.add(l);
            }
            return answerL;
        }
    }
}
