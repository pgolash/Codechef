package LeetCode.Arrays;

/**
 * Created by prashantgolash on 29/11/15.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long length = (long)Math.min(C, G) - (long)Math.max(A, E);
        long breadth = (long)Math.min(D, H) - (long)Math.max(B, F);
        long commonArea = 0;

        if (length > 0 && breadth > 0) {
            commonArea = length * breadth;
        }

        int A1 = (C - A) * (D - B);
        int A2 = (G - E) * (H - F);

        int x = (int) (A1 + A2 - commonArea);

        return x;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-1500000001, 0,-1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
