package LeetCode.RotatedSortedArrays;

/**
 * Created by prashantgolash on 9/22/15.
 */
public class SearchInRotatedSortedArrayNonDuplicate {

    public static void main(String[] args) {
        int[] num = {1};
        //System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, 0));
        //System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, 1));
        System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, 0));
        //System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, 4));
        //System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, 5));
        //System.out.println(new SearchInRotatedSortedArrayNonDuplicate().search(num, -1));
    }

    public int search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }

    public int search(int low, int high, int[] nums, int target) {
        if (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            } else {
                if (nums[low] < nums[middle]) {
                    if (target >= nums[low] && target <= nums[middle]) {
                        return search(low, middle - 1, nums, target);
                    } else {
                        return search(middle + 1, high, nums, target);
                    }
                } else {
                    if (middle + 1 <= high && target >= nums[middle + 1] && target <= nums[high]) {
                        return search(middle + 1, high, nums, target);
                    } else {
                        return search(low, middle - 1, nums, target);
                    }
                }
            }
        }

        return -1;
    }
}
