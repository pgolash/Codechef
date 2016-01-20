package LeetCode.Tree;

import java.util.*;

/**
 * Created by prashantgolash on 19/01/16.
 */
public class BinaryTreeVerticalOrderTraversal {
    private  class TreeColumnNode {
        public TreeNode treeNode;
        int col;
        public TreeColumnNode (TreeNode node, int col) {
            this .treeNode = node;
            this .col = col;
        }
    }

    public List <List<Integer >> verticalOrder (TreeNode root) {
        List <List <Integer >> res = new ArrayList<>();
        if (root == null ) {
            return res;
        }
        LinkedList<TreeColumnNode> queue = new LinkedList <> ();
        Map<Integer, List <Integer >> map = new HashMap<>();
        queue.offer ( new TreeColumnNode (root, 0 ));
        int curLevel = 1 ;
        int nextLevel = 0 ;
        int min = 0 ;
        int max = 0 ;

        while (! queue.isEmpty ()) {
            TreeColumnNode node = queue.poll ();
            if (map.containsKey (node.col)) {
                map.get (node.col) .add (node.treeNode.val);
            } else {
                map.put (node.col, new ArrayList <Integer> (Arrays.asList (node.treeNode.val)));
            }
            curLevel-- ;

            if (node.treeNode.left != null ) {
                queue.offer( new TreeColumnNode (node.treeNode.left, node.col - 1 ));
                nextLevel ++ ;
                min = Math.min (node.col - 1 , min);
            }
            if (node.treeNode.right != null ) {
                queue.offer ( new TreeColumnNode (node.treeNode.right, node.col + 1 ));
                nextLevel ++ ;
                max = Math.max (node.col + 1 , max);
            }
            if (curLevel == 0 ) {
                curLevel = nextLevel;
                nextLevel = 0 ;
            }
        }

        for ( int i = min; i <= max; i ++ ) {
            res.add (map.get (i));
        }

        return res;
    }
}
