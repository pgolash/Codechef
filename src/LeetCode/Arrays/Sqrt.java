package LeetCode.Arrays;

/**
 * Created by prashantgolash on 10/24/15.
 */
public class Sqrt {

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.mySqrt(1));
        System.out.println(s.mySqrt(2));
        System.out.println(s.mySqrt(64));
        System.out.println(s.mySqrt(238));
        System.out.println(s.mySqrt(1111));
        System.out.println(s.mySqrt(11212));
    }

    public int mySqrt(int x) {
        return mySqrt(x, 1, x / 2);

    }

    public int mySqrt(int x, int low, int high) {
        if (x == 1 || x == 0) {
            return x;
        } else {
            int middle = (low + high) / 2;
            if ((middle == x / middle) || ((x / middle) > middle && (x / (middle + 1)) < (middle + 1))) {
                return middle;
            } else if ((x / middle) > middle) {
                return mySqrt(x, middle + 1, high);
            } else {
                return mySqrt(x, low, middle - 1);
            }
        }
    }
}
