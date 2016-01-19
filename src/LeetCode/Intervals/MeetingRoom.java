package LeetCode.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by prashantgolash on 10/01/16.
 */

    class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }

public class MeetingRoom {

    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.end > b.start;
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length ==0) {
            return true;
        }

        // Sort according to the start time
        Arrays.sort(intervals, new IntervalComparator());

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (isOverlapped(prev, curr)) {
                return false;
            }
            prev = curr;
        }

        return true;
    }
}
