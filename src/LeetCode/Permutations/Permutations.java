package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> myL = new ArrayList<List<Integer>>();
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[0]);
            myL.add(l);
            return myL;
        } else {
            List<List<Integer>> n = new ArrayList<List<Integer>>();

            for (int i = 0; i < nums.length; i++) {

                int temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;


                List<List<Integer>> l = permute(Arrays.copyOfRange(nums, 1, nums.length));
                for (List<Integer> x : l) {
                    List<Integer> m = new ArrayList<>();
                    m.add(nums[0]);
                    m.addAll(x);
                    n.add(m);
                }

                temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;

            }

            return n;
        }
    }

}
