package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 9/13/15.
 */
public class NQueensII {

    class Wrapper {
        int x;
        Wrapper() {
            x = 0;
        }
    }

    public int totalNQueens(int n) {
        Wrapper w = new Wrapper();
        List<Integer> currSol = new ArrayList<>();
        findSolutions(n, 1, currSol, w);

        return w.x;
    }

    public void findSolutions(int n, int cntQueen, List<Integer> currSol, Wrapper w) {
        if (cntQueen == n + 1) {
            w.x++;
        } else {

            List<Integer> copySoln = new ArrayList<>();
            copySoln.addAll(currSol);

            for (int pos = 1; pos <= n; pos++) {
                if (isValidPosition(pos, cntQueen, currSol)) {
                    currSol.add(pos);
                    findSolutions(n, cntQueen + 1, currSol, w);
                    currSol = new ArrayList<>();
                    currSol.addAll(copySoln);
                }
            }

        }
    }

    public boolean isValidPosition(int givenPosition, int currIdx, List<Integer> currSol) {
        boolean valid = true;
        for (int i = currIdx - 2; i >= 0; i--) {
            // (otherPosition, i) ; (givenPosition, currIdx)
            int otherPosition = currSol.get(i);
            if (otherPosition == givenPosition || (Math.abs(givenPosition - otherPosition) == Math.abs(currIdx - (i + 1)))) {
                valid = false;
                break;
            }
        }

        return valid;
    }
}
