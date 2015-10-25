package LeetCode.Tree;

import java.util.TreeMap;

/**
 * Created by prashantgolash on 10/24/15.
 */


class AugmentedTreeNode {
    TreeNode node;
    int numLNode;
    int numRNode;
}

public class KthSmallest {

    class Wrapper {
        boolean found;
        TreeNode foundNode;
        Wrapper() {
            this.found = false;
            this.foundNode = null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Wrapper wrapper = new Wrapper();
        numNodes(root, wrapper, k);
        return wrapper.foundNode.val;
    }

    public int numNodes(TreeNode node, Wrapper wrapper, int k) {
        if (node == null) {
            return 0;
        } else {
            int right = 0;
            int left = numNodes(node.left, wrapper, k);
            if (left + 1 == k) {
                wrapper.found = true;
                wrapper.foundNode = node;
            }
            if (!wrapper.found) {
                right = numNodes(node.right, wrapper, k - (left + 1));
            }
            return left + right + 1;
        }
    }
}