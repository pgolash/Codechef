package LeetCode.Arrays;

/**
 * Created by pgolash on 8/28/2015.
 */
public class ProductExceptItself {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int fwdProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            fwdProduct *= nums[i];
            nums[i] = fwdProduct;
        }

        int reverseProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            reverseProduct *= copy[i];
            copy[i] = reverseProduct;
        }

        // nums[i] = a[0]    * a[1]      * a[i]
        // copy[i] = copy[i] * copy[i+1] * copy[i+2] ... * copy[nums.length-1]

        for (int i = 0; i < nums.length; i++) {

            if (i >= 1 && i <= nums.length - 2) {
                copy[i] = nums[i - 1] * copy[i + 1];
            } else if (i == 0) {
                copy[i] = copy[i + 1];
            } else {
                assert i == nums.length - 1;
                copy[i] = nums[i - 1];
            }
        }

        return copy;
    }
}
