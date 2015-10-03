package LeetCode.Arrays;

import java.util.List;

/**
 * Created by prashantgolash on 10/2/15.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevList = triangle.get(0);
        List<Integer> currList = null;

        for (int i = 1; i < triangle.size(); i++) {
            int currListSize = triangle.get(i).size();
            currList = triangle.get(i);

            for (int j = 0; j < currListSize; j++) {
                if (j == 0) {
                    currList.set(j, currList.get(j) + prevList.get(j));
                } else if (j == currListSize - 1) {
                    currList.set(j, currList.get(j) + prevList.get(j - 1));
                } else {
                    int min = Math.min(prevList.get(j), prevList.get(j - 1));
                    currList.set(j, currList.get(j) + min);
                }
            }
            prevList = currList;
        }

        if (currList == null) {
            currList = prevList;
        }

        int minSum = Integer.MAX_VALUE;
        for (int i : currList) {
            if (i < minSum) {
                minSum = i;
            }
        }

        return minSum;
    }
}
