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

    }

    public int trap(int[] height) {

        int maxWater = 0;
        int[] leftMaxIdx = new int[height.length];
        int[] rightMaxIdx = new int[height.length];

        populateLeft(height, leftMaxIdx);
        populateRight(height, rightMaxIdx);

        boolean isDone = false;
        Packet currPacket = new Packet(0, 0);

        while (!isDone) {
            maxWater += waterAtThisIndex(currPacket.idx,
                                         leftMaxIdx[currPacket.idx],
                                         rightMaxIdx[currPacket.idx],
                                         height,
                                         currPacket);
            isDone = currPacket.idx >= height.length;
        }

        return maxWater;
    }

    public void populateLeft(int[] height, int[] leftIdx) {
        leftIdx[0] = -1;
        int max = height[0];
        int maxIdx = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= max) {
                leftIdx[i] = -1;
                max = height[i];
                maxIdx = i;
            } else {
                leftIdx[i] = maxIdx;
            }
        }
    }

    public void populateRight(int[] height, int[] rightIdx) {
        rightIdx[height.length - 1] = -1;
        int max = height[height.length - 1];
        int maxIdx = height.length - 1;

        for (int i = maxIdx - 1; i >= 0; i--) {
            if (height[i] >= max) {
                rightIdx[i] = -1;
                max = height[i];
                maxIdx = i;
            } else {
                rightIdx[i] = maxIdx;
            }
        }
    }

    public int waterAtThisIndex(int idx, int leftIdx, int rightIdx, int[] height, Packet packet) {
        int totalWater = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (leftIdx != -1 ) {
            leftHeight = height[leftIdx];
        }
        if (rightIdx != -1) {
            rightHeight = height[rightIdx];
        }

        int optimalHeight = Math.min(leftHeight, rightHeight);
        int currIdx = idx;

        while (currIdx > leftIdx) {
            if (height[currIdx] <= optimalHeight) {
                totalWater += (optimalHeight - height[currIdx]);
                currIdx--;
            } else {
                break;
            }
        }

        currIdx = idx;

        while (currIdx < rightIdx) {
            if (height[currIdx] <= optimalHeight) {
                totalWater += (optimalHeight - height[currIdx]);
                currIdx++;
            } else {
                break;
            }
        }

        packet.idx = currIdx + 1;
        return totalWater;
    }
}