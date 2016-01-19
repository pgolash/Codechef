package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 05/01/16.
 */
public class MaximumSumSubarray {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            Map<Integer, Integer> sumIdx = new HashMap<>();
            sumIdx.put(nums[0], 0);
            int currSum = nums[0];
            int maxWindow = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                currSum += nums[i];

                if (!sumIdx.containsKey(currSum)) {
                    sumIdx.put(currSum, i);
                }

                if (currSum == k) {
                    maxWindow = i + 1;
                } else {
                    if (sumIdx.containsKey(currSum - k)) {
                        maxWindow = Math.max(maxWindow, i - sumIdx.get(currSum - k));
                    }
                }
            }
            return maxWindow;
        }
    }
}
