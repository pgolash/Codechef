package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by prashantgolash on 10/21/15.
 */
public class BSTIterator {
    private Stack<TreeNode> stk;
    private Map<TreeNode, Boolean> visitedMap;

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        if (root != null) {
            stk.push(root);
        }
        visitedMap = new HashMap<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode rootN = stk.pop();
        Boolean visited = visitedMap.get(rootN.left);

        if (rootN.left != null && (visited == null || visited == false)) {
            while (rootN != null) {
                stk.push(rootN);
                rootN = rootN.left;
            }

            TreeNode answerNode = stk.pop();

            if (answerNode.right != null) {
                stk.push(answerNode.right);
            }

            visitedMap.put(answerNode, true);
            return answerNode.val;

        } else {
            if (rootN.right != null) {
                stk.push(rootN.right);
            }

            visitedMap.put(rootN, true);
            return rootN.val;
        }
    }
}
