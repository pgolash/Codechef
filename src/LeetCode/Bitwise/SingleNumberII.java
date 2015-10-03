package LeetCode.Bitwise;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[] {2, 2, 2, 3}));
    }



    public int singleNumber(int[] nums) {
        int targetNumber = 0;
        for (int i = 1; i <= 32; i++) {
            int numToAnd = 1 << (i - 1);
            int sum = 0;
            for (int j : nums) {
                if ( (j & numToAnd) != 0) {
                    sum += 1;
                }
            }

            int currBit = sum % 3;
            if (currBit != 0) {
                targetNumber |= (currBit << (i - 1));
            }
        }

        return targetNumber;

    }
}
