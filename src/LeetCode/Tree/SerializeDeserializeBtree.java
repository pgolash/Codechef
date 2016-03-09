package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> x = new ArrayList<>();
        List<Integer>y = new ArrayList<>();
        getFactorsHelper(1, 2, y, x, n);
        for (List<Integer> l : x) {
            System.out.println(l);
        }
        return x;
    }

    public void getFactorsHelper(int prod, int currNumber, List<Integer> currList, List<List<Integer>> answer, int target) {
        if (prod > target) {
            return;
        } else if (prod == target) {
            answer.add(new ArrayList<Integer>(currList));
        } else {
            for (int idx = currNumber; idx <= target / 2; idx++) {
                if (target % (prod * idx) == 0) {
                    currList.add(idx);
                    getFactorsHelper(prod * idx, idx, currList, answer, target);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        SerializeDeserializeBtree s = new SerializeDeserializeBtree();
        s.getFactors(20);
    }
}
