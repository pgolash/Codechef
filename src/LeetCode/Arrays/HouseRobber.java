package LeetCode.Arrays;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }  else {
            int incl = nums[0];
            int excl = 0;

            for (int i = 1; i < nums.length; i++) {
                int temp = incl;
                incl = Math.max(incl, excl + nums[i]);
                excl = temp;
            }

            return incl;
        }
    }
}
