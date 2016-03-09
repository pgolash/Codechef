package Design.Practice.BinaryIterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by prashantgolash on 20/02/16.
 */
public class BinaryIterator<T> implements Iterator<Object> {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        T val;
    }

    private Stack<TreeNode> stk;
    private boolean isDone;

    BinaryIterator(TreeNode node) {
        if (node == null) {
            isDone = true;
        } else {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
        }

    }

    @Override
    public boolean hasNext() {
        return !isDone;
    }

    @Override
    public Object next() {
        TreeNode x = stk.pop();
        if (stk.isEmpty() && x.right == null) {
            isDone = true;
        } else {
            if (x.right != null) {
                TreeNode y = x.right;
                while (y != null) {
                    stk.push(y);
                    y = y.left;
                }
            }
        }

        return x.val;
    }
}
