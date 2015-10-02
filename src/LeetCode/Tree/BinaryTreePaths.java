package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> myL = new ArrayList<>();
        binaryTreePaths(root, myL, "");
        return myL;
    }

    public void binaryTreePaths(TreeNode root, List<String> myL, String s) {
        StringBuilder bld = new StringBuilder(s);
        StringBuilder tempBld = new StringBuilder(s);
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            bld.append(root.val);
            myL.add(bld.toString());
        } else {
            binaryTreePaths(root.left, myL, bld.append(root.val).append("->").toString());
            bld = tempBld;
            binaryTreePaths(root.right, myL, bld.append(root.val).append("->").toString());
        }
    }
}
