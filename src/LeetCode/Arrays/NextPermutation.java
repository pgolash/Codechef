package LeetCode.Arrays;

import java.security.acl.AclNotFoundException;
import java.util.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] num = new int[] {2, 1, 1, 2};

        new NextPermutation().nextPermutation(num);

        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;

        while (idx >= 0) {
            int smallestLargestIdx = getSmallestLargest(idx + 1, nums, nums[idx]);
            if (smallestLargestIdx != -1) {
                int temp = nums[idx];
                nums[idx] = nums[smallestLargestIdx];
                nums[smallestLargestIdx] = temp;
                Arrays.sort(nums, idx + 1, nums.length);
                break;
            }
            idx--;
        }

        if (idx < 0) {
            Arrays.sort(nums);
        }
    }

    public int getSmallestLargest(int idx, int[] nums, int givenNum) {
        int smallestLargest = Integer.MAX_VALUE;
        int smallestLargestIdx = -1;
        for (int currIdx = idx; currIdx < nums.length; currIdx++) {
            if (nums[currIdx] > givenNum) {
                if (nums[currIdx] < smallestLargest) {
                    smallestLargestIdx = currIdx;
                }
            }
        }

        return smallestLargestIdx;
    }
}
