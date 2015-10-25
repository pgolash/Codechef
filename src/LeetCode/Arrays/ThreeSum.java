package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 10/23/15.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] S = new int[] {-1, 1, 2, -2};
        // -2 -1 1 2
        List<List<Integer>> l = new ThreeSum().threeSum(S);

        for (List<Integer> x : l) {
            for (int i = 0; i < x.size(); i++) {
                System.out.print(x.get(i) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == prev) {
                continue;
            } else {
                List<Integer[]> x = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), (-1) * nums[i]);
                if (x.size() != 0) {
                    for (int j = 0 ; j < x.size(); j++) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(x.get(j)[0]);
                        l.add(x.get(j)[1]);
                        answerList.add(l);
                    }
                }
                prev = nums[i];
            }
        }
        return answerList;
    }

    public List<Integer[]> twoSum(int[] nums, int target) {
        int sIdx = 0;
        int eIdx = nums.length - 1;
        List<Integer[]> l = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        while (sIdx < eIdx) {
            int calcSum = nums[sIdx] + nums[eIdx];
            if (calcSum == target && prev != nums[sIdx]) {
                Integer[] ans = new Integer[2];
                ans[0] = nums[sIdx];
                ans[1] = nums[eIdx];
                l.add(ans);
                prev = nums[sIdx];
                sIdx++;
                eIdx--;
            } else if (calcSum > target) {
                eIdx--;
            } else {
                sIdx++;
            }
        }
        return l;
    }
}
