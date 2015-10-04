package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by prashantgolash on 10/3/15.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        List<List<Integer>> x = new Subsets().subsets(arr);

        for (List<Integer> l : x) {
            System.out.print(l.toArray());
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int middle = (nums.length) / 2;

        for (int i = 0; i <= middle - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        sol.add(new ArrayList<>());

        int cnt = nums.length - 1;
        while (cnt >= 0) {
            List<List<Integer>> solTillNow = new ArrayList<List<Integer>>();
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

        return sol;
    }

}
