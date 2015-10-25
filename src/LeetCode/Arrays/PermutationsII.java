package LeetCode.Arrays;

import java.util.*;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] n = new int[] {1, 1, 2, 2};
        List<List<Integer>> l = new PermutationsII().permuteUnique(n);
        for (List<Integer> x : l) {
            for (int i : x) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    class Data {
        private int lowVal;
        private int highVal;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (lowVal != data.lowVal) return false;
            return highVal == data.highVal;

        }

        @Override
        public int hashCode() {
            int result = lowVal;
            result = 31 * result + highVal;
            return result;
        }

        Data(int lowVal, int highVal) {
            this.lowVal = lowVal;
            this.highVal = highVal;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return permuteUniqueS(nums);
    }

    public List<List<Integer>> permuteUniqueS(int[] nums) {
        Map<Data, Object> p = new HashMap<>();
        if (nums.length == 1) {
            List<List<Integer>> myL = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            myL.add(l);
            return myL;
        } else {
            List<List<Integer>> n = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int smaller = nums[i] > nums[0] ? nums[0] : nums[i];
                int bigger = nums[i] > nums[0] ? nums[i] : nums[0];
                boolean shouldEnter = !p.containsKey(new Data(smaller, bigger)) || (i == 0);
                if (shouldEnter) {
                    p.put(new Data(smaller, bigger), null);
                    int temp = nums[i];
                    nums[i] = nums[0];
                    nums[0] = temp;
                    List<List<Integer>> l = permuteUniqueS(Arrays.copyOfRange(nums, 1, nums.length));
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
            }
            return n;
        }
    }
}