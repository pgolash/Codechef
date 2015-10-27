package LeetCode.Arrays;

import java.util.*;

/**
 * Created by prashantgolash on 10/25/15.
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 2, 3, 6, 7};
        List<List<Integer>> l = new CombinationSum().combinationSum(arr, 7);

        for (List<Integer> x : l) {
            for (int i : x) {
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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Data[] data = new Data[target + 1];
        for (int i = 0; i <= target; i++) {
            data[i] = new Data();
        }
        data[0].answer.add(new ArrayList<>());
        Arrays.sort(candidates);
        for (int c = 0; c < candidates.length; c++) {
            for (int t = 1; t <= target; t++) {
                if (candidates[c] > t) {
                    continue;
                } else {
                    Set<List<Integer>> w = data[t - candidates[c]].answer;
                    for (List<Integer> x : w) {
                        List<Integer> nW = new ArrayList<>();
                        nW.addAll(x);
                        nW.add(candidates[c]);
                        data[t].answer.add(nW);
                    }
                }
            }
        }
        List<List<Integer>> y = new ArrayList<>();
        for (List<Integer> x : data[target].answer) {
            y.add(x);
        }
        return y;
    }
}