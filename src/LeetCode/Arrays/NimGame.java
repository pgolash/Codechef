package LeetCode.Arrays;
/**
 * Created by prashantgolash on 10/24/15.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        } else {

            int firstLP = n - 3;

            while(firstLP >= 0 && firstLP != 1) {
                firstLP -= 4;
            }

            return !(firstLP == 1);
        }
    }
}