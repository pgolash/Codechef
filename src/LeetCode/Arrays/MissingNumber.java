package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int idealSum =(n * ( n + 1)) / 2;
        int currSum = 0;

        for (int i : nums) {
            currSum += i;
        }

        return idealSum - currSum;

    }
}
