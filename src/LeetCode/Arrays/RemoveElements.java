package LeetCode.Arrays;

/**
 * Created by prashant on 8/25/2015.
 */
public class RemoveElements {
    public static void main(String[] args) {


    }

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        } else {

            int currIdx = 0;
            int endIdx = 0;

            while (endIdx < nums.length) {
                if (nums[endIdx] == val) {
                    endIdx++;
                } else {
                    nums[currIdx] = nums[endIdx];
                    currIdx++;
                    endIdx++;
                }
            }
            return currIdx;
        }
    }
}
