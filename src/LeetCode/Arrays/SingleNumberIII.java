package LeetCode.Arrays;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0};
        int[] ar = new SingleNumberIII().singleNumber(arr);
        System.out.println(ar[0]);
        System.out.println(ar[1]);
    }

    public int[] singleNumber(int[] nums) {
        int ans = 0;

        for (int z : nums) {
            ans ^= z;
        }

        // ans = x1 xor x2

        // find last bit where the x1 x2 differs
        int cnt = 0;
        int temp = ans;

        while (temp > 0) {
            temp >>= 1;
            cnt++;
        }

        int numToXor = 1 << (cnt - 1);
        int ans1 = 0;
        int ans2 = 0;

        for (int z : nums) {
            if ((numToXor & z) != 0) {
                ans1 ^= z;
            } else {
                ans2 ^= z;
            }
        }
        return new int[] {ans1, ans2};
    }
}
