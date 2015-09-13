package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 9/12/15.
 */
public class NQueens {

    public static void main(String[] args) {
        List<List<String>> m = new NQueens().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        StringBuilder bld = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            bld.append('.');
        }

        String s = bld.toString();

        List<List<String>> solution = new ArrayList<List<String>>();
        List<Integer> currSol = new ArrayList<>();
        findSolutions(n, 1, currSol, solution, s);

        return solution;

    }

    public void findSolutions(int n, int cntQueen, List<Integer> currSol, List<List<String>> globalSoln, String glob) {
        if (cntQueen == n + 1) {
            List<String> newSoln = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                StringBuilder s = new StringBuilder(glob);
                s.setCharAt(currSol.get(i - 1) - 1, 'Q');
                newSoln.add(s.toString());
            }
            globalSoln.add(newSoln);
        } else {

            List<Integer> copySoln = new ArrayList<>();
            copySoln.addAll(currSol);

            for (int pos = 1; pos <= n; pos++) {
                if (isValidPosition(pos, cntQueen, currSol)) {
                    currSol.add(pos);
                    findSolutions(n, cntQueen + 1, currSol, globalSoln, glob);
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
