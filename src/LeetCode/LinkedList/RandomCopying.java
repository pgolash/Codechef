package LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 9/7/15.
 */
public class RandomCopying {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {

            if (head == null) {
                return null;
            } else {

                List<RandomListNode> saveList = new ArrayList<>();
                RandomListNode temp = head;

                RandomListNode copyNode = new RandomListNode(-1);
                RandomListNode saveCopyNode = copyNode;

                while (temp != null) {
                    RandomListNode next = temp.next;
                    saveList.add(temp);

                    copyNode.next = new RandomListNode(temp.label);
                    copyNode.next.random = temp;
                    temp.next = copyNode.next;
                    temp = next;

                    copyNode = copyNode.next;
                }

                saveList.add(null);

                copyNode.next = null;

                //Point again to beginning
                copyNode = saveCopyNode.next;

                // Adjust copyNode's random pointer
                while (copyNode != null) {

                    if (copyNode.random.random != null) {
                        copyNode.random = copyNode.random.random.next;
                    } else {
                        copyNode.random = null;
                    }

                    copyNode = copyNode.next;
                }

                Iterator<RandomListNode> itr = saveList.iterator();
                temp = head;
                itr.next();

                while(itr.hasNext()) {
                    temp.next = itr.next();
                    temp = temp.next;
                }

                return saveCopyNode.next;
            }
        }
    }

}
