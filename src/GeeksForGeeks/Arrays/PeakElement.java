package GeeksForGeeks.Arrays;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by prashantgolash on 04/01/16.
 */
public class PeakElement {
    public int peak(int[] num) {
        int max = num[0];
        int index = 0;
        for (int i = 1; i <= num.length - 2; i++) {
            int prev = num[i - 1];
            int curr = num[i];
            int next = num[i + 1];

            if (curr > prev && curr > next && curr > max) {
                index = i;
                max = curr;
            }
        }

        if (num[num.length - 1] > max) {
            return num.length - 1;
        }

        return index;
    }


//    int findPeakElement(const vector<int> &num) {
//        int n = num.size();
//        if(n == 1) {
//            return 0;
//        }
//
//        int start = 0;
//        int end = n - 1;
//        int mid = 0;
//
//        while(start <= end) {
//            mid = start + (end - start) / 2;
//            if((mid == 0 || num[mid] >= num[mid - 1]) &&
//                    (mid == n - 1 || num[mid] >= num[mid + 1])) {
//                return mid;
//            }else if(mid > 0 && num[mid-1] > num[mid]) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return mid;
//    }
}