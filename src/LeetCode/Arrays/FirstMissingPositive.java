package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/12/15.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {1, 1}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {2, 1}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {3, 2, 1}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {1, 3, 2, 1}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {2, 2}));
        System.out.println( new FirstMissingPositive().firstMissingPositive(new int[] {0, 1, 2}));
    }

    public int firstMissingPositive(int[] nums) {

        int idx = 0;

        while (idx < nums.length) {
            int currIdx = idx;
            int saveIdx = currIdx;
            boolean loopReached = false;
            int pointToIndex = nums[currIdx] - 1;
            int saveIndex = currIdx;

            while (!loopReached && isValidIndex(pointToIndex, nums)) {
                int saveNum = nums[pointToIndex];
                nums[pointToIndex] = Integer.MIN_VALUE;
                if (saveNum != Integer.MIN_VALUE) {
                    pointToIndex = saveNum - 1;
                } else {
                    pointToIndex = saveNum;
                }

                loopReached = pointToIndex == saveIndex;
            }

            if (loopReached) {
                nums[saveIdx] = Integer.MIN_VALUE;
            }

            idx++;
        }

        idx = 0;
        for (idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != Integer.MIN_VALUE) {
                break;
            }
        }

        return idx + 1;

    }

    public boolean isValidIndex(int idx, int[] nums) {
        int minIdx = -1;
        int maxIdx = nums.length;
        return idx > minIdx && idx < maxIdx;
    }
}
