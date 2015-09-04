package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/3/15.
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{2, 1}));

    }

    public int candy(int[] ratings) {
        if (ratings == null | ratings.length == 0) {
            return 0;
        } else {

            int[] finalRatings = new int[ratings.length];
            boolean isDone = false;
            int savedIndex = 0;
            int originalIdx = 0;

            int idx = 0;
            int cnt;


            while (!isDone) {
                originalIdx = idx;
                cnt = 1;

                while (idx + 1 < ratings.length && ratings[idx] > ratings[idx + 1]) {
                    idx++;
                }

                if (idx != originalIdx) {
                    savedIndex = idx + 1;
                } else {
                    savedIndex = originalIdx + 1;
                }

                idx = savedIndex - 1;

                while (idx > originalIdx) {
                    finalRatings[idx--] = cnt++;
                }

                if (originalIdx >= 1 && ratings[originalIdx] > ratings[originalIdx - 1]) {
                    finalRatings[originalIdx] = Math.max(cnt, finalRatings[originalIdx - 1] + 1);
                } else {
                    finalRatings[originalIdx] = cnt;
                }

                idx = savedIndex;
                isDone = idx >= ratings.length;

            }

            cnt = 0;

            for (int i = 0; i < ratings.length; i++) {
                cnt += finalRatings[i];
            }

            return cnt;
        }
    }
}
