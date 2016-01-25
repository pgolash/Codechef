package LeetCode.Bitwise;

/**
 * Created by prashantgolash on 24/01/16.
 */
public class RangeAnd {
    int rangeBitwiseAnd(int m, int N) {
        int i = 0 ;
        while (m != N) {
            m >>= 1 ;
            N >>= 1 ;
            ++ i;
        }
        return (m << i);
    }
}
