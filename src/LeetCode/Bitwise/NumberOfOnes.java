package LeetCode.Bitwise;

/**
 * Created by prashantgolash on 8/19/15.
 */
public class NumberOfOnes {
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                weight++;
                n >>= 1;
            }
        }

        return weight;

    }
}
