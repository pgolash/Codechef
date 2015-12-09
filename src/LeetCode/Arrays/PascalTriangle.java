package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 28/11/15.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> x = new ArrayList<>();

        if (numRows == 0) {
            return x;
        }

        List<Integer> y = new ArrayList<>();
        y.add(1);

        x.add(y);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < y.size(); j++) {
                temp.add(y.get(j - 1) + y.get(j));
            }
            temp.add(1);
            x.add(temp);
            y = temp;
        }

        return x;
    }
}
