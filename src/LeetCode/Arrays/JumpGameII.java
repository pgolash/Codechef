package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/20/15.
 */
public class JumpGameII {

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new JumpGameII().jump(new int[]{1, 2, 3}));
        System.out.println(new JumpGameII().jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new JumpGameII().jump(new int[]{1, 2 }));

    }

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        } else {

            boolean isDone = false;
            int currIdx = 0;
            int minJump = 0;
            int max;
            int prevMax = nums[0];

            while (currIdx < nums.length && !isDone) {
                max = Integer.MIN_VALUE;
                if (currIdx + nums[currIdx] >= nums.length - 1) {
                    minJump += 1;
                    isDone = true;
                } else {
                    int indexToCheck = prevMax;
                    currIdx++;

                    while (currIdx <= indexToCheck) {
                        if (currIdx + nums[currIdx] > max) {
                            max = currIdx + nums[currIdx];
                        }

                        if (currIdx + nums[currIdx] >= nums.length - 1) {
                            minJump += 1;
                            isDone = true;
                            break;
                        }

                        currIdx++;
                    }

                    currIdx--;
                    prevMax = max;
                    minJump += 1;
                }
            }

            return minJump;
        }

    }
}
