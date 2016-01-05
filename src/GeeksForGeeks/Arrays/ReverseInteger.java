package GeeksForGeeks.Arrays;

import java.util.List;

/**
 * Created by prashantgolash on 01/01/16.
 */
    interface NestedInteger {
        // Returns true if this NestedInteger holds a single integer, rather than a nested list
        public boolean isInteger();

        // Returns the single integer that this NestedInteger holds, if it holds a single integer
        // Returns null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Returns the nested list that this NestedInteger holds, if it holds a nested list
        // Returns null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class ReverseInteger {

        public int depthSum (List<NestedInteger> input) {
            //Implement this function
            int depth = getDepth(input);
            return depthSumHelper(input, depth);
        }

        private int getDepth(List<NestedInteger> input) {
            if (input == null || input.size() == 0) {
                return 0;
            }

            int depth = 0;
            for (int i = 0; i < input.size(); i++) {
                if (!input.get(i).isInteger()) {
                    depth = Math.max(depth, getDepth(input.get(i).getList()));
                }
            }

            return depth + 1;
        }

        private int depthSumHelper(List<NestedInteger> input, int level) {
            if (input == null || input.size() == 0) {
                return 0;
            }

            int sum = 0;
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i).isInteger()) {
                    sum += input.get(i).getInteger() * level;
                } else {
                    sum += depthSumHelper(input.get(i).getList(), level - 1);
                }
            }

            return sum;
        }
    }
