package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashantgolash on 8/29/15.
 */
public class InsertInterval {

    class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {

    }

    public boolean isIntersecting(Interval i1, Interval i2) {
        if (i1 == null || i2 == null) {
            return false;
        } else {
            return !(i1.start > i2.end || i2.start > i1.end);
        }
    }

    public Interval mergeIntervals(Interval i1, Interval i2) {
        Interval i3 = new Interval();
        i3.start = Math.min(i1.start, i2.start);
        i3.end = Math.max(i1.end, i2.end);

        return i3;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (intervals == null) {
            return null;
        } else if (newInterval == null) {
            return intervals;
        } else {
            List<Interval> myL = new ArrayList<>();
            for (Interval currInterval : intervals) {
                if (newInterval != null) {
                    if (isIntersecting(newInterval, currInterval)) {
                        newInterval = mergeIntervals(newInterval, currInterval);
                    } else {
                        if (newInterval.end < currInterval.start) {
                            myL.add(newInterval);
                            newInterval = null;
                        }
                        myL.add(currInterval);
                    }
                } else {
                    myL.add(currInterval);
                }
            }
            if (newInterval != null) {
                myL.add(newInterval);
            }
            return myL;
        }

    }
}
