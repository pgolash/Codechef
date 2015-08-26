package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant on 8/25/2015.
 */
public class PathSumII {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> mySol = new ArrayList<List<Integer>>();
        findSolutions(root, mySol, new ArrayList<Integer>(), sum);
        return mySol;
    }

    public void findSolutions(TreeNode root, List<List<Integer>> sol, List<Integer> currL, int sum) {
        if (root == null) {
            return;
        } else {
            ArrayList<Integer> newL = new ArrayList<Integer>();
            newL.addAll(currL);
            newL.add(root.val);

            if (root.left == null && root.right == null && root.val == sum) {
                sol.add(newL);
            } else {
                findSolutions(root.left, sol, newL, sum - root.val);
                findSolutions(root.right, sol, newL, sum - root.val);
            }
        }

    }

}
