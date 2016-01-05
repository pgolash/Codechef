package LeetCode.Stack;

import java.util.Stack;

/**
 * Created by prashantgolash on 28/12/15.
 */
public class FindCelebrity {
    public int findCelebrity(int n) {
        int celebrity = -1;
        if (knows(1, 2)) {
            celebrity = 2;
        } else {
            celebrity = 1;
        }

        for (int i = 3; i <= n; i++) {
            if (!knows(i, celebrity)) {
                celebrity = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == celebrity) {
                continue;
            } else {
                if (knows(celebrity, i)) {
                    celebrity = -1;
                    break;
                }
            }
        }

        return celebrity;
    }

    boolean knows(int a, int b) {
        return true;
    }

}
