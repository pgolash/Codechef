package LeetCode.Tree;

/**
 * Created by prashantgolash on 29/12/15.
 */
public class SerializeDeserializeBtree {
    class Wrapper {
        int idx;
        Wrapper() {
            idx = 0;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder bld = new StringBuilder();
        serialize(root, bld);
        return bld.toString();
    }

    public void serialize(TreeNode root, StringBuilder bld) {
        if (root == null) {
            bld.append("#,");
        } else {
            bld.append(root.val + ",");
            serialize(root.left, bld);
            serialize(root.right, bld);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","), new Wrapper());
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String[] data, Wrapper wrapper) {
        if (data[wrapper.idx].equals("#")) {
            wrapper.idx++;
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(data[wrapper.idx]));
            wrapper.idx++;
            root.left = deserialize(data, wrapper);
            root.right = deserialize(data, wrapper);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(1);

        String s = new SerializeDeserializeBtree().serialize(root);
        TreeNode r = new SerializeDeserializeBtree().deserialize(s);
    }
}
