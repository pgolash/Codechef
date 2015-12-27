package LeetCode.Bitwise;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        // 0 1 : 1 0
        // 1 0 : 0 1

        for (int i = 0; i <= 15; i++) {
            int hNumber = (1 & (n >> (31 - i)));
            int lNumber = (1 & (n >> i));

            if ((hNumber ^ lNumber) == 1) {
                n ^= (1 << (31 - i));
                n ^= (1 << i);
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(65536));
    }

    // 0 0 1 0 0 0
    // 0 0 0 1 0 0
}
