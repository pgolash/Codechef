package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/29/15.
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx = m - 1;
        int nIdx = n - 1;

        int tIdx = m + n - 1;

        while (mIdx >= 0 && nIdx >= 0) {
            if (nums1[mIdx] > nums2[nIdx]) {
                nums1[tIdx] = nums1[mIdx];
                mIdx--;
            } else {
                nums1[tIdx] = nums2[nIdx];
                nIdx--;
            }
            tIdx--;
        }

        while (mIdx >= 0) {
            nums1[tIdx] = nums1[mIdx];
            mIdx--;
            tIdx--;
        }

        while (nIdx >= 0) {
            nums1[tIdx] = nums2[nIdx];
            nIdx--;
            tIdx--;
        }
    }
}
