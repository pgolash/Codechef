package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class CombinationsNCK {
    public static void main(String[] args) {
        List<List<Integer>> x = new CombinationsNCK().combine(5, 3);
        for (List<Integer> u : x) {
            for (int k : u) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        NCK(x, y, n, k, 1);
        return x;
    }

    public void NCK(List<List<Integer>> answer,
                    List<Integer> currList,
                    int remainingN,
                    int remainingK,
                    int currNumber) {
        if (remainingN < remainingK) {
            return;
        } else if (remainingK == 0) {
            answer.add(new ArrayList<Integer>(currList));
        } else {
            List<Integer> x = new ArrayList<>();
            x.addAll(currList);
            x.add(currNumber);
            NCK(answer, x, remainingN - 1, remainingK - 1, currNumber + 1);
            x.remove(x.size() - 1);
            NCK(answer, x, remainingN - 1, remainingK, currNumber + 1);
        }
    }
}