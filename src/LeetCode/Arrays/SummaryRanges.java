package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class SummaryRanges {

    public static void main(String[] args) {

        int[] nums = new int[]{-1};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        } else {
            List<String> x = new ArrayList<>();
            int idx = 0;

            while (idx < nums.length) {
                int prevNum = nums[idx];
                StringBuilder bld = new StringBuilder(prevNum + "");

                int save = idx;
                idx++;

                while(idx < nums.length && nums[idx] == prevNum + 1) {
                    prevNum = nums[idx];
                    idx++;
                }

                idx--;
                if (save != idx) {
                    bld.append("->");
                    bld.append(nums[idx]);
                }

                idx++;
                x.add(bld.toString());
            }

            return x;
        }
    }
}
