package LeetCode.Arrays;

/**
 * Created by prashantgolash on 22/01/16.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Step 1: Accmulate the number of citations for each bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n) {
                buckets[citations[i]]++;
            } else {
                buckets[n]++;
            }
        }

        // Step 2: iterate the citations from right to left.
        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += buckets[i];
            if (numPapers >= i) {
                return i;
            }
        }

        return 0;
    }

    public int getHIndex(int[] citations, int low, int high) {
        int cit =  0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (citations[mid] >= citations.length - mid) {
                cit = Math.min(citations[mid], citations.length - mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return cit;
    }

    public static void main(String[] args) {
        int[] c = new int[] {1, 1, 1, 1, 1};
        System.out.println(new HIndex().hIndex(c));
    }
}
