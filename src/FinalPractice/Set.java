package FinalPractice;

import java.util.*;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class Set {
    public void printSet(int[] set, int setIdx, int currIdx, int[] inputSet) {
        System.out.print("[");

        for (int j = 0; j < setIdx; j++) {
            System.out.print(set[j] + " ");
        }

        System.out.print("]");
        System.out.println("");

        for (int idx = currIdx; idx < inputSet.length; idx++) {
            if (idx >= 1 && inputSet[idx] != inputSet[idx - 1] || idx == 0) {
                set[setIdx] = inputSet[idx];
                int save = inputSet[idx];
                inputSet[idx] = Integer.MAX_VALUE;
                printSet(set, setIdx + 1, idx + 1, inputSet);
                inputSet[idx] = save;
            }
        }
    }

    public void printUniquePerms(int[] nums, int currIdx) {
        if (currIdx == nums.length) {
            System.out.print("[");
            for (int x : nums) {
                System.out.print(x + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        for (int i = currIdx; i < nums.length; i++) {
            if (canSwap(nums, currIdx, i)) {
                int temp = nums[i];
                nums[i] = nums[currIdx];
                nums[currIdx] = temp;

                printUniquePerms(nums, i + 1);

                temp = nums[i];
                nums[i] = nums[currIdx];
                nums[currIdx] = temp;
            }
        }
    }

    boolean canSwap(int[] nums, int start, int currIdx) {
        if (start == currIdx) {
            return true;
        } else {
            for (int i = start; i < currIdx; i++) {
                if (nums[i] == nums[currIdx]) {
                    return false;
                }
            }
            return true;
        }

    }

    public void printSum(int[] candidates, int[] sol, int solIdx, int target, int currSum, int runningIdx) {
        if (currSum > target) {
            return;
        } else if (currSum == target) {
            for (int i = 0; i < solIdx; i++) {
                System.out.print(sol[i] + " ");
            }
            System.out.println();
        }

        for(int i = runningIdx; i < candidates.length; i++) {
            if (i == 0 || i > 0 && candidates[i] != candidates[i - 1]) {
                sol[solIdx] = candidates[i];

                int save = candidates[i];
                candidates[i] = Integer.MAX_VALUE;

                printSum(candidates, sol, solIdx + 1, target, currSum + sol[solIdx], i + 1);

                candidates[i] = save;
            }
        }

    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> bldStk = new Stack<>();

        int maxArea = 0;
        int idx = 0;

        while (idx < height.length) {
            if (bldStk.isEmpty() || height[idx] > height[bldStk.peek()]) {
                bldStk.push(idx);
                idx++;
            } else {

                int thisIndex = bldStk.pop();
                int area = height[thisIndex] * (idx - thisIndex);
                if (bldStk.isEmpty()) {
                    area += height[thisIndex] * (thisIndex);
                }

                maxArea = Math.max(area, maxArea);
            }
        }

        idx = height.length;
        while (!bldStk.isEmpty()) {
            int thisIndex = bldStk.pop();
            int area = height[thisIndex] * (idx - thisIndex);
            if (bldStk.isEmpty()) {
                area += height[thisIndex] * (thisIndex + 1);
            }

            maxArea = Math.max(area, maxArea);

        }

        return maxArea;
    }

     class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public TreeNode upsideDown(TreeNode root) {
        TreeNode prevLeftNode = null;
        TreeNode prevRightNode = null;
        TreeNode head = null;

        while (root != null) {

            if (root.left == null) {
                head = root;
            }

            TreeNode newRigtNode = root;
            TreeNode newLeftNode = root.right;
            TreeNode nextNode = root.left;

            root.right = prevRightNode;
            root.left = prevLeftNode;

            prevLeftNode = newLeftNode;
            prevRightNode = newRigtNode;

            root = nextNode;
        }

        return head;
    }

//    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
//        if (root == null) {
//            return null;
//        } else if (root == a || root == b) {
//            return root;
//        } else {
//            TreeNode left = LCA(root.left, a, b);
//            TreeNode right = LCA(root.left, a, b);
//
//            if (left != null && right != null) {
//                return root;
//            } else if ((left == null) && (right == null)) {
//                return null;
//            } else if (right == null){
//                return left;
//            } else {
//                return right;
//            }
//        }
//    }

    class LCANode {
        Integer count;
        TreeNode lcaNode;

        LCANode(TreeNode lca, Integer count) {
            this.lcaNode = lca;
            this.count = count;
        }
    }

    public LCANode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return new LCANode(null, 0);
        } else {
            boolean found = false;
            if (root == a || root == b) {
              found = true;
            }

            LCANode lft = LCA(root.left, a, b);
            LCANode rght = LCA(root.right, a, b);

            if(found) {
                if (lft.count == 1 || rght.count == 1) {
                    return new LCANode(root, 2);
                } else {
                    return new LCANode(null, 1);
                }
            } else {
                return lft.count > rght.count ? lft : rght;
            }
        }
    }

    public int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            int d = power(x, n / 2);

            if (n % 2 == 0) {
                return d * d;
            } else {
                if (n > 0) {
                    return d * d * x;
                } else {
                    return d * d * (1 / x);
                }
            }
        }
    }

    public List<Integer> mergeKIterator(List<Iterator<Integer>> iteratorList) {
        IteratorNode[] nodes = new IteratorNode[iteratorList.size()];
        List<Integer> y = new ArrayList<>();
        int idx = 0;

        for (Iterator it : iteratorList) {
            nodes[idx++] = new IteratorNode(it);
        }

        PriorityQueue<Integer> x = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nodes[o1].next() - nodes[o2].next();
            }
        });

        for (int i = 0; i < idx; i++) {
            if (nodes[i].hasNext()) {
                x.add(i);
            }
        }

        while (!x.isEmpty()) {
            int minIndex = x.poll();
            y.add(nodes[minIndex].next());

            if (nodes[minIndex].hasNext()) {
                x.add(minIndex);
            }
        }

        return y;
    }

    class IteratorNode {
        Iterator<Integer> it;
        int data;

        IteratorNode(Iterator<Integer> it) {
            this.it = it;
        }

        public int next() {
            return data;
        }

        public boolean hasNext() {
            if (it.hasNext()) {
                data = it.next();
                return true;
            }
            return false;
        }
    }

    interface Elem {
        public boolean isElem();
        public boolean isComplex();
        public List<Elem> getList();
        public Integer getValue();
    }

    class DeepIterator implements Iterator<Integer> {

        Elem topElement = null;
        Stack<Iterator<Elem>> stk = null;

        DeepIterator(List<Elem> list) {
            stk.push(list.iterator());
            topElement = null;
        }

        public Integer next() {
            int val = topElement.getValue();
            topElement = null;
            return val;
        }

        public boolean hasNext() {
            if (topElement != null) {
                return true;
            } else {
                while (!stk.isEmpty()) {
                    if (stk.peek().hasNext()) {
                        Elem e = stk.peek().next();
                        if (e.isElem()) {
                            topElement = e;
                            return true;
                        } else {
                            stk.push(e.getList().iterator());
                        }
                    } else {
                        stk.pop();
                    }
                }
                return false;
            }
        }
    }

    class Vector2D {
        Iterator<List<Integer>> mainIter;
        Iterator<Integer> currIter;
        Integer elem = null;

        public Vector2D(List<List<Integer>> vec2d) {
            mainIter = vec2d.iterator();
            if (mainIter.hasNext()) {
                currIter = mainIter.next().iterator();
            }
        }


        public int next() {
            Integer save = elem;
            elem = null;
            return save;
        }


        public boolean hasNext() {
            if (elem != null) {
                return true;
            } else {
                while (currIter != null) {
                    if (currIter.hasNext()) {
                        elem = currIter.next();
                        return true;
                    } else {
                        if (mainIter.hasNext()) {
                            currIter = mainIter.next().iterator();
                        } else {
                            currIter = null;
                        }
                    }
                }
                return false;
            }
        }
    }

    public int getMaxProduct(int[] arr) {
        int maxNegProd = 1;
        int maxPosProd = 1;
        int maxProd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (maxNegProd < 0) {
                    maxPosProd = maxNegProd * arr[i];
                } else {
                    maxPosProd = 1;
                }
                maxNegProd = maxPosProd * arr[i];
            } else if (arr[i] == 0) {
                maxProd = Math.max(maxProd, Math.max(maxPosProd, maxNegProd));
                maxNegProd = maxPosProd = 1;
            } else {
                maxPosProd *= arr[i];
                if (maxNegProd < 0) {
                    maxNegProd *= arr[i];
                }
            }
        }

        return Math.max(maxProd, maxPosProd);
    }

    public int minimumWindowSubstring(String s, String inputString) {
        Map<Character, Integer> toBeFoundCount = new HashMap<>();
        Map<Character, Integer> foundCount = new HashMap<>();

        // update count
        int sIdx = 0;
        int eIdx = 0;
        int count = 0;
        int minL = Integer.MAX_VALUE;

        while (eIdx < s.length()) {
            if (shouldIncrementCount(s.charAt(eIdx), toBeFoundCount, foundCount)) {
                count++;
            }

            if (count == inputString.length()) {
                while (canIncrement(s.charAt(sIdx), toBeFoundCount, foundCount)) {
                    sIdx++;
                }

                if (eIdx - sIdx < minL) {
                    minL = eIdx - sIdx;
                }

                int cnt = toBeFoundCount.get(s.charAt(sIdx));
                toBeFoundCount.put(s.charAt(sIdx), cnt - 1);
                sIdx++;
            }
            eIdx++;
        }

        return minL;

    }

    public boolean shouldIncrementCount(char c, Map<Character, Integer> tobeFoundCount, Map<Character, Integer> foundCount) {
        if (tobeFoundCount.containsKey(c)) {
            return foundCount.get(c) < tobeFoundCount.get(c);
        }
        return false;
    }

    public boolean canIncrement(char c, Map<Character, Integer> tobeFoundCount, Map<Character, Integer> foundCount) {
        if (!tobeFoundCount.containsKey(c)) {
            return true;
        } else {
            return tobeFoundCount.get(c) > foundCount.get(c);
        }
    }

    class Wrapper {
        int idx;
    }

    public void getSerializedTree(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append('#');
        } else {
            str.append(root.val);
            getSerializedTree(root.left, str);
            getSerializedTree(root.right, str);
        }
    }

    public TreeNode getDeserializeTree(String tree, Wrapper wrapper) {
        if (wrapper.idx >= tree.length()) {
            return null;
        } else if (tree.charAt(wrapper.idx) == '#') {
            wrapper.idx++;
            return null;
        } else {
            TreeNode root = new TreeNode(tree.charAt(wrapper.idx));
            wrapper.idx++;
            root.left = getDeserializeTree(tree, wrapper);
            root.right = getDeserializeTree(tree, wrapper);
            return root;
        }
    }

    class BSTIterator implements Iterator {

        private Stack<TreeNode> stk = null;
        private boolean isDone = false;

        BSTIterator(TreeNode root) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !isDone;
        }

        public Integer next() {
            TreeNode x = stk.pop();
            int val = (int)x.val;
            if (x.right != null) {
                x = x.right;
                while (x != null) {
                    stk.push(x);
                    x = x.left;
                }
            } else {
                isDone = stk.isEmpty();
            }
            return val;
        }
    }

    public int firstMissingPositive(int[] nums) {
        // seperate positive and negative

        int idx = 0;

        while (idx < nums.length) {
            if (nums[idx] <= 0) {
                idx++;
                continue;
            } else {
                int idxToTarget = nums[idx] - 1;
                if (idxToTarget < nums.length) {
                    int save = nums[idxToTarget];
                    nums[idxToTarget] = Integer.MIN_VALUE;
                    nums[idx] = save;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }


    class DP {
        List<List<Integer>> ans;
        DP() {
            ans = new ArrayList<>();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        DP[][] sol = new DP[n + 1][k + 1];

        for (int i = 0 ; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                sol[i][j] = new DP();
            }
        }

        // solutions

        for (int i = 1; i <= 9; i++) {
            for (int sum = 1; sum <= n; sum++) {
                if (i > sum) {
                    continue;
                }
                for (int j = 1; j <= k; j++) {
                    List<List<Integer>> x = sol[sum - i][j - 1].ans;
                    List<List<Integer>> z = sol[sum][j].ans;

                    if (sum == i && j == 1) {
                        List<Integer> u = new ArrayList<>();
                        u.add(i);
                        z.add(u);
                    } else {
                        // if there are indeed any solutions then only add
                        for (List<Integer> y : x) {
                            List<Integer> u = new ArrayList<>(y);
                            u.add(i);
                            z.add(u);
                        }
                    }
                }
            }
        }

        return sol[n][k].ans;
    }

    public String integerToRoman(int val) {
        char[] powTen = {'M', 'C', 'X', 'I'};
        char[] powFive = {'C', 'B', 'A'};
        int cnt = 0;
        String[] bld = new String[7];

        while (val != 0) {
            int digit = val % 10;

            switch (val) {
                case 1:
                case 2:
                case 3:
                    //bld.


                    break;


            }

        }

        return "";
    }


    public static void main(String[] args) {
        Set s = new Set();
        List<List<Integer>> x = s.combinationSum3(3, 7);
        for (List<Integer> y : x) {
            System.out.println(y);
        }

    }

    public boolean isImage(TreeNode n1, TreeNode n2) {
        return n1.val == n2.val && isImage(n1.left, n2.right) && isImage(n1.right, n2.left);
    }

    public void printPerm(char[] perms, int currIdx) {
        if (currIdx == perms.length) {


        }

        for (int i = currIdx; i < perms.length; i++) {


        }
    }
}