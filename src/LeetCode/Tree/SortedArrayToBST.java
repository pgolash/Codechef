package LeetCode.Tree;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        } else {
            int middle = (low + high) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = sortedArrayToBST(nums, low, middle - 1);
            root.right = sortedArrayToBST(nums, middle + 1, high);
            return root;
        }
    }
}
