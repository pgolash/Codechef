package LeetCode.RangeQuery;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class NumArray {
    private int[] DP;
    public NumArray(int[] nums) {
        DP = new int[nums.length];
        DP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            DP[i] = DP[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return DP[j];
        } else {
            return DP[j] - DP[i - 1];
        }
    }
}