package LeetCode.Arrays;

/**
* Created by prashant on 8/27/2015.
*/
public class MinimumSizeSubarray {

public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currIdx = 0;
        int endIdx = 0;

        int totalSum = 0;
        boolean isDone = false;
        long minLen = Long.MAX_VALUE;

        while (!isDone) {
            totalSum += nums[endIdx];
            if (totalSum >= s) {
                while (totalSum >= s) {
                    totalSum -= nums[currIdx];
                    currIdx++;
                }

                if (endIdx - currIdx + 2 < minLen) {
                    minLen = endIdx - currIdx + 2;
                }
            }

            endIdx++;
            isDone = endIdx >= nums.length;
        }

        if (minLen != Long.MAX_VALUE) {
            return (int) minLen;
        } else {
            return 0;
        }
}

public static void main(String[] args) {
    int[] arr = {2,3,1,2,4,3};
    System.out.println(new MinimumSizeSubarray().minSubArrayLen(7, arr));


}
}
