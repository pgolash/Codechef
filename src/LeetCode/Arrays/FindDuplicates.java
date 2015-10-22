package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/29/15.
 */
public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int arrLength = nums.length;
        int n = arrLength - 1;

        int arrSum = 0;
        int idealSum = (n * (n  + 1) ) / 2;

        for (int i : nums) {
            arrSum += i;
        }

        return arrSum - idealSum;

    }
}
