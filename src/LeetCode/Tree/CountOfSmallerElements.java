package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by prashantgolash on 25/01/16.
 */
public class CountOfSmallerElements {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            res.add(insert(root, nums[i]));
        }
        Collections.reverse(res);
        return res;
    }

     public int insert(TreeNode root, int num) {
         int thisCount = 0;
         while (true) {
             if (root.val >= num) {
                 root.count++;
                 if (root.left == null) {
                     root.left = new TreeNode(num);
                     break;
                 }
                 else {
                     root = root.left;
                 }
             }
             else {
                 thisCount += root.count;
                 if (root.right == null) {
                     root.right = new TreeNode(num);
                     break;
                 }
                 else {
                     root = root.right;
                 }
             }
         }
         return thisCount;
     }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int count;
        public TreeNode(int value) {
            this.val = value;
            this.count = 1;
        }
    }
}
