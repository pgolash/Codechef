package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 21/01/16.
 */
public class UniqueBSTs {
    class Data {
        List<TreeNode> treeNodes;
        Data() {
            treeNodes = new ArrayList<>();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        Data[][] DP = new Data[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            DP[i][i] = new Data();
            DP[i][i].treeNodes.add(new TreeNode(i));
            for (int j = i + 1; j <= n; j++) {
                DP[i][j] = new Data();
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    List<TreeNode> leftTree = getNodes(i, k - 1, DP);
                    List<TreeNode> rightTree = getNodes(k + 1, j, DP);

                    if (leftTree == null) {
                        for (TreeNode r : rightTree) {
                            TreeNode root = new TreeNode(k);
                            root.right = r;
                            DP[i][j].treeNodes.add(root);
                        }
                    } else if (rightTree == null) {
                        for (TreeNode l : leftTree) {
                            TreeNode root = new TreeNode(k);
                            root.left = l;
                            DP[i][j].treeNodes.add(root);
                        }
                    } else {
                        for (TreeNode l : leftTree) {
                            for (TreeNode r : rightTree) {
                                TreeNode root = new TreeNode(k);
                                root.left = l;
                                root.right = r;
                                DP[i][j].treeNodes.add(root);
                            }
                        }
                    }
                }
            }
        }

        return DP[1][n].treeNodes;
    }

    public List<TreeNode> getNodes(int i, int j, Data[][] DP) {
        if (j < i) {
            return null;
        } else {
            return DP[i][j].treeNodes;
        }
    }
}
