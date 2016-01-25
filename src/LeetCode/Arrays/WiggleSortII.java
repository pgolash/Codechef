package LeetCode.Arrays;

/**
 * Created by prashantgolash on 25/01/16.
 */
public class WiggleSortII {

    //public void wiggleSort(int[] nums) {
//    if (nums.length == 0 || nums.length == 1)
//            return;
//    Arrays.sort(nums);
//    int[] res = new int[nums.length];
//    int mid = nums.length/2;
//    if (nums.length % 2 != 0)
//    mid++;
//    int lo = mid - 1;
//    int hi = nums.length - 1;
//    for (int i = 0; i < nums.length; i++) {
//        if (i % 2 == 0) {
//            res[i] = nums[lo];
//            lo--;
//        } else {
//            res[i] = nums[hi];
//            hi--;
//        }
//    }
//    for (int i = 0; i < nums.length; i++) {
//        nums[i] = res[i];
//    }
//}


    public void wiggleSort(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }
        int median = getMedian(nums);


        int higher = 0, lower = nums.length - 1, current = 0;

        while (current <= lower) {
            if (nums[reIndex(current, nums.length)] == median) {
                current++;
            } else if (nums[reIndex(current, nums.length)] < median) {
                swap(nums, reIndex(current, nums.length), reIndex(lower--, nums.length));
            } else {
                swap(nums, reIndex(current++, nums.length), reIndex(higher++, nums.length));
            }
        }
    }



    private int reIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }

    private int getMedian(int[] nums) {

        int start = 0, end = nums.length - 1, target = nums.length / 2;
        while (true) {
            swap(nums, start, (start + end) / 2);
            int swapIndex = start, current = start + 1;

            while (current <= end) {
                if (nums[current] >= nums[start]) swap(nums, ++swapIndex, current);
                current++;
            }

            swap(nums, start, swapIndex);
            if (swapIndex - start == target) return nums[swapIndex];
            else if (swapIndex - start > target) end = swapIndex - 1;
            else {
                target -= (swapIndex - start + 1);
                start = swapIndex + 1;
            }
        }

    }



    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
