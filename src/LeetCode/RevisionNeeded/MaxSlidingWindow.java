package LeetCode.RevisionNeeded;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by prashantgolash on 10/22/15.
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[] {1};
        System.out.println(new MaxSlidingWindow().maxSlidingWindow(arr, 1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] B = new int[n - k + 1];
        Deque<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!Q.isEmpty() && nums[i] >= nums[Q.peekLast()])
                Q.removeLast();

            Q.addLast(i);
        }

        for (int i = k; i < n; i++) {
            B[i - k] = nums[Q.peekFirst()];
            while (!Q.isEmpty() && nums[i] >= nums[Q.peekLast()])
                Q.removeLast();

            while (!Q.isEmpty() && Q.peekFirst() <= i - k)
                Q.removeFirst();

            Q.addLast(i);
        }

        B[n - k] = nums[Q.peekFirst()];
        return B;
    }
}
