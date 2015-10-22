package LeetCode.Arrays;

/**
 * Created by prashantgolash on 9/27/15.
 */
public class TrapRainWater {

    class Packet {
        int totalWater;
        int idx;

        Packet(int totalWater, int idx) {
            this.totalWater = totalWater;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int[] water1 = new int[] {10, 0, 0, 10, 11, 12};
        System.out.println(new TrapRainWater().trap(water1));
    }

    public int trap(int[] height) {
        return -1;
    }

}