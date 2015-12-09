package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> y = new ArrayList<>();
        y.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < y.size(); j++) {
                temp.add(y.get(j - 1) + y.get(j));
            }
            temp.add(1);
            y = temp;
        }

        return y;
    }
}
