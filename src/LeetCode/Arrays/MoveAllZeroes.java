package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class MoveAllZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        } else {
            int sIdx = 0;
            int eIdx = 0;

            boolean isDone = false;

            while (!isDone) {
                if (nums[eIdx] != 0) {
                    nums[sIdx] = nums[eIdx];
                    if (sIdx != eIdx) {
                        nums[eIdx] = 0;
                    }
                    sIdx++;
                }
                eIdx++;
                isDone = eIdx >= nums.length;
            }
        }
    }
}
