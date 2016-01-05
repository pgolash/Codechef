package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 27/12/15.
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        List<List<Integer>> x = new CombinationSumIII().combinationSum3(3, 7);
        for (List<Integer> k1: x) {
            System.out.println(k1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr =new int[k];
        List<List<Integer>> x = new ArrayList<>();
        solution(arr, 0, k, n, 0, 0, x);
        return x;
    }

    public void solution(int[] arr, int arrIndex, int k, int n, int currNumber, int totalSum, List<List<Integer>> y) {
        if (arrIndex == k) {
            if(totalSum == n) {
                List<Integer> z = new ArrayList<>();
                for (int x : arr) {
                    z.add(x);
                }
                y.add(z);
            }
            return;
        }

        for (int idx = currNumber + 1; idx <= 9; idx++) {
            if (totalSum + idx > n) {
                break;
            } else {
                arr[arrIndex] = idx;
                solution(arr, arrIndex + 1, k, n, idx, totalSum + arr[arrIndex], y);
            }
        }
    }
}
