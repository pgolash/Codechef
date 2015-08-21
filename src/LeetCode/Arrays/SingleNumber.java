package LeetCode.Arrays;

/**
 * Created by prashantgolash on 8/19/15.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;

    }
}
