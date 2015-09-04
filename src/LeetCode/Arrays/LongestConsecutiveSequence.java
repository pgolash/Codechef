package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 9/2/15.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{0}));
    }

    class Pointer {
        Pointer blink;
        Pointer flink;
        boolean visited;

        Pointer() {
            this.blink = this.flink = null;
            this.visited = false;
        }
    }

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        } else {

            Map<Integer, Pointer> dataMap = new HashMap<>();
            int currMax = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {

                if (dataMap.containsKey(nums[i])) {
                    continue;
                }

                int currNumber = nums[i];
                Pointer currNode = new Pointer();
                Pointer back = dataMap.get(currNumber - 1);
                Pointer forward = dataMap.get(currNumber + 1);


                if (back != null) {
                    currNode.blink = back;
                    back.flink = currNode;
                }

                if (forward != null) {
                    currNode.flink = forward;
                    forward.blink = currNode;
                }

                dataMap.put(currNumber, currNode);
            }

            for (Integer num : dataMap.keySet()) {
                if (!dataMap.get(num).visited) {
                    Pointer currPointer = dataMap.get(num);
                    Pointer savePointer = currPointer;
                    int cnt = 0;

                    while (currPointer != null) {
                        cnt++;
                        currPointer.visited = true;
                        currPointer = currPointer.blink;
                    }

                    currPointer = savePointer;
                    Pointer forward = currPointer.flink;

                    while (forward != null) {
                        cnt++;
                        forward.visited = true;
                        forward = forward.flink;
                    }

                    if (cnt > currMax) {
                        currMax = cnt;
                    }

                }
            }
            return currMax;
        }
    }
}
