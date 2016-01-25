package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 19/01/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            outputToResult(lower, upper, result);
            return result;
        }

        // leading missing range
        if (nums[0] - lower > 0) {
            outputToResult(lower, nums[0] - 1, result);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                outputToResult(nums[i - 1] + 1, nums[i] - 1, result);
            }
        }

        // trailing missage ranges
        if (upper - nums[nums.length - 1] > 0) {
            outputToResult(nums[nums.length - 1] + 1, upper, result);
        }

        return result;
    }

    private void outputToResult(int start, int end, List<String> result) {
        StringBuffer sb = new StringBuffer();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start + "->" + end);
        }

        result.add(sb.toString());
    }
}
