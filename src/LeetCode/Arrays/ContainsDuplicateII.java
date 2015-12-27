package LeetCode.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;

        if (k >= n - 1) {
            k = n - 1;
        }

        for (int i = 0; i <= k; i++) {
            if (s.contains(nums[i])) {
                return true;
            } else {
                s.add(nums[i]);
            }
        }

        for (int i = k + 1; i < nums.length; i++) {
            s.remove(nums[i - k - 1]);
            if (s.contains(nums[i])) {
                return true;
            } else {
                s.add(nums[i]);
            }
        }
        return false;
    }
}
