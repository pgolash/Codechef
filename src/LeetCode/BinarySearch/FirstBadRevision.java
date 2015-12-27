package LeetCode.BinarySearch;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class FirstBadRevision {

    public static void main(String[] args) {
        System.out.println(new FirstBadRevision().firstBadVersion(7));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int hi = n;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (isBadVersion(mid)) hi = mid;
            else low = mid + 1;
        }
        return hi;
    }

    public boolean isBadVersion(int x) {
        return true;
    }
}
