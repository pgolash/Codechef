package LeetCode.Duplicates;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashantgolash on 9/28/15.
 */
public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } else {
            Map<Integer, Object> m = new HashMap<>();
            boolean flag = false;

            for (int i : nums) {
                if (m.containsKey(i)) {
                    flag = true;
                    break;
                } else {
                    m.put(i, null);
                }
            }
            return flag;
        }
    }
}
