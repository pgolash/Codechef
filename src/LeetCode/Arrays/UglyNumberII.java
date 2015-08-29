package LeetCode.Arrays;

/**
 * Created by prashant on 8/27/2015.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];

        ugly[0] = 1;

        int twoIdx = 0;
        int threeIdx = 0;
        int fiveIdx = 0;

        for (int i = 1; i <= n - 1 ; i++) {
            int ans;
            int ugly2 = ugly[twoIdx] * 2;
            int ugly3 = ugly[threeIdx] * 3;
            int ugly5 = ugly[fiveIdx] * 5;

            if (ugly2 < ugly3 && ugly2 < ugly5) {
                ans = ugly2;
                twoIdx++;
            } else if (ugly3 < ugly2 && ugly3 < ugly5) {
                ans = ugly3;
                threeIdx++;
            } else if (ugly5 < ugly2 && ugly5 < ugly3) {
                ans = ugly5;
                fiveIdx++;
            } else if (ugly3 == ugly2 && ugly3 != ugly5) {
                ans = ugly3;
                threeIdx++;
                twoIdx++;
            } else if (ugly2 == ugly5 && ugly3 != ugly2) {
                ans = ugly2;
                fiveIdx++;
                twoIdx++;
            } else if (ugly3 == ugly5 && ugly3 != ugly2) {
                ans = ugly3;
                threeIdx++;
                fiveIdx++;
            } else {
                ans = ugly3;
                threeIdx++;
                twoIdx++;
                fiveIdx++;
            }

            ugly[i] = ans;

        }

        return ugly[n-1];

    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(7));
    }
}
