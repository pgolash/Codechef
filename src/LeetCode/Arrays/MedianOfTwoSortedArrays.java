package LeetCode.Arrays;

import java.util.Stack;

/**
 * Created by prashantgolash on 19/01/16.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

    public int calculate(String s) {
        int sign = 1;
        int prevSign = 1;
        int totalSum = 0;
        Stack<Integer> signStack = new Stack<>();
        signStack.push(1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                signStack.push(signStack.peek() * prevSign);
            } else if (s.charAt(i) == ')') {
                signStack.pop();
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' ) {
                prevSign = s.charAt(i) == '+' ? 1 : -1;
            } else {
                totalSum += signStack.peek() * getNum(s, i);
            }
        }
        return 1;
    }

    int getNum(String s, int idx) {
        int num = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                num = num * 10 + s.charAt(idx) - '0';
                idx++;
            } else {
                break;
            }
        }
        return num;
    }
}