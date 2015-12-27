package GeeksForGeeks.Arrays;

import java.util.Arrays;

/**
 * Created by prashantgolash on 12/12/15.
 */
public class NumTriangles {
    public static void main(String[] args) {

    }

    int findNumberOfTriangles(int arr[], int n)
    {
        // Sort the array elements in non-decreasing order
        Arrays.sort(arr);

        // Initialize count of triangles
        int count = 0;

        // Fix the first element.  We need to run till n-3
        // as the other two elements are selected from
        // arr[i+1...n-1]
        for (int i = 0; i < n-2; ++i)
        {
            // Initialize index of the rightmost third
            // element
            int k = i+2;

            // Fix the second element
            for (int j = i+1; j < n; ++j)
            {
                // Find the rightmost element which is
                // smaller than the sum of two fixed elements
                // The important thing to note here is, we
                // use the previous  value of k. If value of
                // arr[i] + arr[j-1] was greater than arr[k],
                // then arr[i] + arr[j] must be greater than k,
                // because the array is sorted.
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                // Total number of possible triangles that can
                // be formed with the two fixed elements is
                //  k - j - 1.  The two fixed elements are arr[i]
                // and arr[j].  All elements between arr[j+1]/ to
                // arr[k-1] can form a triangle with arr[i] and arr[j].
                // One is subtracted from k because k is incremented
                // one extra in above while loop.
                // k will always be greater than j. If j becomes equal
                // to k, then above loop will increment k, because arr[k]
                //  + arr[i] is always greater than arr[k]
                count += k - j - 1;
            }
        }

        return count;
    }

    public int numTriangles(int[] arr) {
        Arrays.sort(arr);
        int cnt = 0;
        int eIdx = arr.length - 1;
        int sIdx = 0;
        while (sIdx <= eIdx - 2) {
            int target = arr[eIdx];
            // processing for eIdx
            int runningIdx = sIdx + 1;
            if (sIdx == 0) {
                int sum = arr[sIdx] + arr[runningIdx];
                while (runningIdx < eIdx && sum <= target) {
                    runningIdx++;
                    sum = arr[sIdx] + arr[runningIdx];
                }
                cnt += eIdx - runningIdx;
            }

            sIdx++;
            while (sIdx <= eIdx - 2 && runningIdx > sIdx) {
                cnt += eIdx - runningIdx;
                runningIdx--;
                while (runningIdx > sIdx && (arr[runningIdx] + arr[sIdx] > arr[eIdx])) {
                    cnt++;
                    runningIdx--;
                }
            }

            sIdx = 0;
            eIdx--;
        }
        return cnt;
    }
}
