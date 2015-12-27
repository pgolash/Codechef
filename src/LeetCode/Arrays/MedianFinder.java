package LeetCode.Arrays;

import LeetCode.RevisionNeeded.MajorityElement;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by prashantgolash on 26/12/15.
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
    }

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.add(num);
        } else {
            if (minHeap.size() == maxHeap.size()) {
                if (maxHeap.peek() > num) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            } else if (minHeap.size() > maxHeap.size()) {
                if (minHeap.peek() < num) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                if (maxHeap.peek() > num) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        double median;
        if (minHeap.size() > maxHeap.size()) {
            median = 1.0 * minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            median = 1.0 * maxHeap.peek();
        } else {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return median;
    }
}
