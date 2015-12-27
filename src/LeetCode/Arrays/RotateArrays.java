package LeetCode.Arrays;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class RotateArrays {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        reverse(nums, 0, nums.length - rotate - 1);
        reverse(nums, nums.length - rotate, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int nums[], int sIdx, int eIdx) {
        if (eIdx > sIdx) {
            int middle = (eIdx - sIdx) / 2;

            for (int cnt = 0; cnt <= middle; cnt++) {
                int temp = nums[eIdx - cnt];
                nums[sIdx + cnt] = temp;
                nums[eIdx - cnt] = nums[sIdx + cnt];
            }
        }
    }
}
