package LeetCode.RevisionNeeded;

import java.util.*;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int middle = (nums.length) / 2;

        for (int i = 0; i <= middle - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        Set<List<Integer>> sol = new HashSet<List<Integer>>();
        sol.add(new ArrayList<>());

        int cnt = nums.length - 1;
        while (cnt >= 0) {
            Set<List<Integer>> solTillNow = new HashSet<List<Integer>>();
            for (List<Integer> l : sol) {
                List<Integer> newL = new ArrayList<>();

                newL.addAll(l);
                newL.add(nums[cnt]);

                solTillNow.add(newL);
                solTillNow.add(l);
            }
            sol = solTillNow;
            cnt--;
        }

        List<List<Integer>> x = new ArrayList<>();

        for (List<Integer> o : sol) {
            x.add(o);
        }

        return x;


    }

}
