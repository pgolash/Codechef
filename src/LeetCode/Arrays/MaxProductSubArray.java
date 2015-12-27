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

    public int maxProduct(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        } else {
            int maxP = Integer.MIN_VALUE;
            int neg = 1;
            int pos = 1;

            for (int i = 0; i < arr.length; i++) {
                int temp;
                if (arr[i] < 0) {
                    if (neg > 0) {
                        temp = 1;
                        maxP = Math.max(maxP, arr[i]);
                    } else {
                        temp = neg * arr[i];
                        maxP = Math.max(maxP, temp);
                    }
                    neg = pos * arr[i];
                    pos = temp;
                } else if (arr[i] == 0) {
                    pos = 1;
                    neg = 1;
                    maxP = Math.max(maxP, 0);
                } else {
                    if (neg < 0) {
                        neg *= arr[i];
                    }
                    pos = pos * arr[i];
                    maxP = Math.max(maxP, pos);
                }
            }

            return maxP;
        }

    }
}