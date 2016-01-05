package LeetCode.BinarySearch;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2};
        System.out.println(new MinimumInRotatedSortedArray().findMin(nums));
    }

    public int findMin(int[] nums) {
        return nums[min(0, nums.length - 1, nums)];
    }

    public int min(int low, int high, int[] nums) {
        if (low >= high) {
            return low;
        } else {
            int middle = (low + high) / 2;
            if (nums[middle] < nums[high]) {
                if (middle >= 1 && nums[middle] < nums[middle - 1]) {
                    return middle;
                } else {
                    return min(low, middle - 1, nums);
                }
            } else {
                return min(middle + 1, high, nums);
            }
        }
    }
}
