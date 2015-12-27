package GeeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 12/12/15.
 */
public class IntersectionSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 5, 6};
        int[] brr = new int[] {1, 2, 3, 4, 4, 4};
        List<Integer> x = new IntersectionSortedArray().intersection(arr, brr);

        for (Integer y : x) {
            System.out.println(y + " ");
        }
    }

    public List<Integer> intersection(int[] a, int[] b) {
        int aIdx = 0;
        int bIdx = 0;
        int aPrev = Integer.MIN_VALUE;
        int bPrev = Integer.MIN_VALUE;
        List<Integer> l = new ArrayList<>();

        while (aIdx < a.length && bIdx < b.length) {
            if (a[aIdx] == aPrev) {
                aIdx++;
                continue;
            }

            if (b[bIdx] == bPrev) {
                bIdx++;
                continue;
            }

            if (a[aIdx] < b[bIdx]) {
                aPrev = a[aIdx];
                aIdx++;
            } else if (a[aIdx] == b[bIdx]) {
                l.add(a[aIdx]);
                aPrev = a[aIdx];
                bPrev = b[bIdx];
                aIdx++;
                bIdx++;
            } else {
                bPrev = b[bIdx];
                bIdx++;
            }
        }

        return l;
    }

}
