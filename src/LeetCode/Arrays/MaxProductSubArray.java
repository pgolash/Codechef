package LeetCode.Arrays;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by prashant on 8/27/2015.
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1, -1, 0, 1};
        int[] nums1 = new int[] {-1, 0, -1, 0};
        int[] nums2 = new int[] {-1, -2, -1, 4};
        int[] nums3 = new int[] {1, 2, 1, 4};
        int[] nums4 = new int[] {-1,2,-3,-4};
        int[] nums5 = new int[] {-1};
        int[] nums6 = new int[] {7,-2,-4};


        System.out.println(new MaxProductSubArray().maxProduct(nums));
        System.out.println(new MaxProductSubArray().maxProduct(nums1));
        System.out.println(new MaxProductSubArray().maxProduct(nums2));
        System.out.println(new MaxProductSubArray().maxProduct(nums3));
        System.out.println(new MaxProductSubArray().maxProduct(nums4));
        System.out.println(new MaxProductSubArray().maxProduct(nums5));
        System.out.println(new MaxProductSubArray().maxProduct(nums6));


    }

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        } else {

            int maxProduct = Integer.MIN_VALUE;

            int currNegProduct = Integer.MIN_VALUE;
            int currPosProduct = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {

                    int temp = currNegProduct;

                    if (currPosProduct != Integer.MIN_VALUE) {
                        currNegProduct = currPosProduct * nums[i];
                    } else {
                        currNegProduct = nums[i];
                    }

                    if (temp != Integer.MIN_VALUE) {
                        currPosProduct = temp * nums[i];
                    } else {
                        currPosProduct = Integer.MIN_VALUE;
                    }

                    maxProduct = Math.max(Math.max(currPosProduct, maxProduct), currNegProduct);
                } else if (nums[i] > 0) {

                    if (currPosProduct == Integer.MIN_VALUE) {
                        currPosProduct = 1;
                    }

                    currPosProduct *= nums[i];

                    if (currNegProduct != Integer.MIN_VALUE) {
                        currNegProduct *= nums[i];
                    }

                    maxProduct = Math.max(currPosProduct, maxProduct);
                } else {
                    maxProduct = Math.max(0, maxProduct);
                    currNegProduct = currPosProduct = Integer.MIN_VALUE;
                }
            }

            return maxProduct;
        }
    }
}