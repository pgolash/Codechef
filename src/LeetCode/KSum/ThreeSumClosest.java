package LeetCode.KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 10/23/15.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] S = new int[] {1, 1, -1, -1, 3};
        // -1 -1 1 1 3
        int l = new ThreeSumClosest().threeSumClosest(S, 1);
        System.out.println(l);

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int sum = -1;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == prev) {
                continue;
            } else {
                int[] x = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
                if (x[0] < minDiff) {
                    sum = x[1] + x[2] + nums[i];
                    minDiff = x[0];
                }
            }
        }
        return sum;
    }

    public int[] twoSum(int[] nums, int target) {
        int sIdx = 0;
        int eIdx = nums.length - 1;
        List<Integer[]> l = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;
        while (sIdx < eIdx) {
            int calcSum = nums[sIdx] + nums[eIdx];
            if (minDiff > Math.abs(calcSum - target)) {
                minDiff = Math.abs(calcSum - target);
                a = nums[sIdx];
                b = nums[eIdx];
            }
            if (calcSum > target) {
                eIdx--;
            } else {
                sIdx++;
            }
        }
        int[] S = new int[3];
        S[0] = minDiff;
        S[1] = a;
        S[2] = b;
        return S;
    }
}