package LeetCode.Arrays;

import java.util.*;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] arr = new int[] {10,1,2,7,6,1,5};
        List<List<Integer>> x = new CombinationSumII().combinationSum2(arr, 8);
        for (List<Integer> u : x) {
            for (int i : u) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    class Data {
        Set<List<Integer>> answer;
        Data() {
            answer = new HashSet<>();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Data[][] data = new Data[candidates.length + 1][target + 1];
        for (int t = 0; t <= target; t++) {
            data[0][t] = new Data();
        }

        for (int i = 0; i <= candidates.length; i++) {
            data[i][0] = new Data();
            data[i][0].answer.add(new ArrayList<>());
        }

        Arrays.sort(candidates);
        for (int c = 1; c <= candidates.length; c++) {
            for (int t = 1; t <= target; t++) {
                data[c][t] = new Data();
                for (List<Integer> u : data[c - 1][t].answer) {
                    data[c][t].answer.add(u);
                }
                if (candidates[c - 1] <= t) {
                    Set<List<Integer>> w = data[c - 1][t - candidates[c - 1]].answer;
                    for (List<Integer> x : w) {
                        List<Integer> nW = new ArrayList<>();
                        nW.addAll(x);
                        nW.add(candidates[c - 1]);
                        data[c][t].answer.add(nW);
                    }
                }
            }
        }
        List<List<Integer>> y = new ArrayList<>();
        for (List<Integer> x : data[candidates.length][target].answer) {
            y.add(x);
        }
        return y;
    }
}
