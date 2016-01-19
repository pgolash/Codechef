package LeetCode.KSum;

import java.util.Arrays;

/**
 * Created by prashantgolash on 8/13/15.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[2];

        int sIdx = 0;
        int eIdx = nums.length - 1;
        int newT = 0;

        while (sIdx < eIdx) {
            newT = nums[sIdx] + nums[eIdx];

            if (newT == target) {
                ans[0] = sIdx;
                ans[1] = eIdx;
                break;
            } else if (newT > target) {
                eIdx--;
            } else {
                sIdx++;
            }
        }

        return ans;

    }
}
