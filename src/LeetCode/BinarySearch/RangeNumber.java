package LeetCode.BinarySearch;

/**
 * Created by prashantgolash on 01/01/16.
 */
public class RangeNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1};
        RangeNumber n = new RangeNumber();
        int[] z = n.searchRange(arr, 1);
        System.out.println(z[0]);
        System.out.println(z[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = getLowRange(target, 0, nums.length - 1, nums);
        arr[1] = getHighRange(target, 0, nums.length - 1, nums);
        return arr;
    }

    public int getLowRange(int number, int low, int high, int[] nums) {
        if (nums[low] > number || nums[high] < number) {
            return  -1;
        } else if (nums[low] == number) {
           return low;
        } else {
            int middle = (low) + (high - low) / 2;
            if (nums[middle] == number && nums[middle - 1] < number) {
                return middle;
            } else if (nums[middle] >= number){
                return getLowRange(number, low, middle - 1, nums);
            } else {
                return getLowRange(number, middle + 1, high, nums);
            }
        }
    }

    public int getHighRange(int number, int low, int high, int[] nums) {
        if (nums[low] > number || nums[high] < number) {
            return  -1;
        } else if (nums[high] == number) {
            return high;
        } else {
            int middle = (low) + (high - low) / 2;
            if (nums[middle] == number && nums[middle + 1] > number) {
                return middle;
            } else if (nums[middle] <= number){
                return getHighRange(number, middle + 1, high, nums);
            } else {
                return getHighRange(number, low, middle - 1, nums);
            }
        }
    }
}
