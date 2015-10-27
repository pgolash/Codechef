package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3};
        System.out.println(new SearchInsertPosition().searchInsert(arr, 2));
    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int low, int high) {
        if (nums[0] >= target) {
            return 0;
        } else if (target < nums[low]) {
            return low;
        } else if (target > nums[high]) {
            return high + 1;
        } else {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                return searchInsert(nums, target, low, middle - 1);
            } else {
                return searchInsert(nums, target, middle + 1, high);
            }
        }
    }
}
