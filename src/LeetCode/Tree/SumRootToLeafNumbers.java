package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/1/15.
 */
public class SumRootToLeafNumbers {
    class Wrapper {
        int totalSum;
        Wrapper() {
            totalSum = 0;
        }
    }

    public int sumNumbers(TreeNode root) {
        Wrapper wrapper = new Wrapper();
        sumNumber(root, 0, wrapper);
        return wrapper.totalSum;
    }

    public void sumNumber(TreeNode root, int numberFromTop, Wrapper sum) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null){
            sum.totalSum += numberFromTop * 10 + root.val;
        } else {
            sumNumber(root.left, numberFromTop * 10 + root.val, sum);
            sumNumber(root.right, numberFromTop * 10 + root.val, sum);
        }
    }
}
