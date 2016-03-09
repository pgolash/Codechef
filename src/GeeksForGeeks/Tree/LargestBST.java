package GeeksForGeeks.Tree;

/**
 * Created by prashantgolash on 21/02/16.
 */
public class LargestBST {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

    }

    class WrapperMin {
        int min;
    }

    class WrapperMax {
        int max;
    }

    class WrapperSize {
        int size;
        int maxSize;
    }

    public static void main(String[] args) {

    }

    public boolean largestBST(TreeNode root, WrapperMax max, WrapperMin min, WrapperSize size) {
        if (root == null) {
            return true;
        } else {
            boolean a = largestBST(root.left, max, min, size);
            int maxV = max.max;

            int lSize = size.size;

            max.max = Integer.MIN_VALUE;
            min.min = Integer.MAX_VALUE;

            boolean b = largestBST(root.right, max, min, size);
            int rSize = size.size;

            if (a && b) {
                if (maxV > root.value && root.value < min.min) {
                    size.size = lSize + rSize + 1;
                    if (size.size > size.maxSize) {
                        size.maxSize = size.size;
                    }

                    min.min = Math.min(root.value, min.min);
                    max.max = Math.max(root.value, max.max);

                    return true;
                }
            }
            return false;
        }
    }


}