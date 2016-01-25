package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class HouseRobber {
    private int robAlongALine(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
        }
        return max[nums.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int maxWithFirst = robAlongALine(
                Arrays.copyOfRange(nums, 0, nums.length - 1)
        );
        int maxWithoutFirst = robAlongALine(
                Arrays.copyOfRange(nums, 1, nums.length)
        );
        return Math.max(maxWithFirst, maxWithoutFirst);
    }
}
