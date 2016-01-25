package LeetCode.Arrays;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by prashantgolash on 25/01/16.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }

        SortedSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long lower = (long) nums[i] - t;
            long upper = (long) nums[i] + t + 1; // use long to avoid overflow,
            //e..g. nums[i] and t is Integer.MAX_VALUE

            SortedSet<Long> boundary = set.subSet(lower, upper);
            if (!boundary.isEmpty()) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
