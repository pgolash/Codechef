package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sIdx = 0;
        int eIdx = 0;

        while (eIdx < nums.length) {
            if (nums[sIdx] != nums[eIdx]) {
                sIdx++;
                nums[sIdx] = nums[eIdx];
            }
            eIdx++;
        }

        return sIdx + 1;
    }
}
