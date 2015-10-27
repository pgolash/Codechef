package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class SortColors {

    public static void main(String[] args) {
        int[] color = new int[] {1, 1, 2};
        new SortColors().sortColors(color);
    }

    public void sortColors(int[] nums) {
        int sIdx = 0;
        int eIdx = nums.length - 1;
        int currIdx = Integer.MIN_VALUE;
        while (sIdx < eIdx) {
            if (nums[sIdx] == 0 && nums[eIdx] == 2) {
                sIdx++;
                eIdx--;
            } else if (nums[sIdx] == 0 && (nums[eIdx] == 0 || nums[eIdx] == 1)) {
                sIdx++;
            } else if (nums[sIdx] == 2 && nums[eIdx] == 0) {
                nums[sIdx] = 0;
                nums[eIdx] = 2;
                sIdx++;
                eIdx--;
            } else if (nums[sIdx] == 2 && nums[eIdx] == 1) {
                nums[eIdx] = 2;
                nums[sIdx] = 1;
                eIdx--;
            } else if (nums[sIdx] == 2 && nums[eIdx] == 2) {
                eIdx--;
            } else if (nums[sIdx] == 1 && nums[eIdx] == 0) {
                nums[sIdx] = 0;
                nums[eIdx] = 1;
                sIdx++;
            } else if (nums[sIdx] == 1 && nums[eIdx] == 1) {
                if (currIdx == Integer.MIN_VALUE) {
                    currIdx = sIdx + 1;
                }
                while (currIdx < eIdx && nums[currIdx] == 1) {
                    currIdx++;
                }
                if (currIdx < eIdx) {
                    if (nums[currIdx] == 2) {
                        nums[currIdx] = 1;
                        nums[eIdx] = 2;
                        eIdx--;
                    } else {
                        nums[sIdx] = 0;
                        nums[currIdx] = 1;
                        sIdx++;
                    }
                } else {
                    break;
                }

                currIdx++;
            } else {
                eIdx--;
            }
        }
    }
}
