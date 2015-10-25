package LeetCode.Bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class GrayCode {

    public static void main(String[] args) {
        List<Integer> x = new GrayCode().grayCode(2);

        for (int o : x) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public List<Integer> grayCode(int n) {
        boolean[] toggle = new boolean[n];
        Arrays.fill(toggle, true);

        List<Integer> x = new ArrayList<>();
        x.add(0);
        int currNumber = 0;
        int cnt;
        for (int idx = 2; idx <= Math.pow(2, n); idx++) {
            for (cnt = 0; cnt < n; cnt++) {
                if (toggle[cnt]) {
                    for (int k = cnt - 1; k >= 0; k--) {
                        toggle[k] = true;
                    }
                    toggle[cnt] = false;
                    break;
                }
            }
            int numToXOR = 1 << cnt;
            currNumber ^= numToXOR;
            x.add(currNumber);
        }

        return x;
    }
}
