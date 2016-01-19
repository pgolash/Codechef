package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 17/01/16.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getMedianElement(int[] nums, int kthNum) {
        if (nums.length <= 5) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        } else {
            // Divide into 5 elements each
            int len = nums.length % 5 == 0 ? (nums.length / 5) : (nums.length / 5 + 1);
            int[] medianArr = new int[len];
            int idx = 0;
            for (int i = 0; i <= nums.length - 5; i += 5) {
                medianArr[idx++] = getMedianElement(Arrays.copyOfRange(medianArr, i, i + 5), 2);
            }

            int med = getMedianElement(medianArr, medianIndex(medianArr));

            int low = 0;
            int high = nums.length - 1;

            // Partition
            while (low < high) {
                while (low < high && nums[low] < med) {
                    low++;
                }

                while (low < high && nums[high] > med) {
                    high--;
                }

                if (low < high) {
                    int temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                }

                low++;
                high--;
            }

            if (low == kthNum) {
                return nums[low];
            } else if (low < kthNum) {
                return getMedianElement(Arrays.copyOfRange(nums, low, nums.length), kthNum - low);
            } else {
                return getMedianElement(Arrays.copyOfRange(nums, 0, low), kthNum);
            }
        }
    }

    public int medianIndex(int[] arr) {
        if (arr.length % 2 == 0) {
            return arr.length / 2;
        } else {
            return arr.length / 2 + 1;
        }
    }
}
