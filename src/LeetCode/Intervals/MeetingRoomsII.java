package LeetCode.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by prashantgolash on 10/01/16.
 */

public class MeetingRoomsII {


    public static void main(String[] args) {
        Interval[] i = new Interval[] {new Interval(1,5),
                                       new Interval(8,9),
                                       new Interval(8,9)
                                      };
        System.out.println(new MeetingRoomsII().minMeetingRooms(i));
    }

    public int minMeetingRooms(Interval[] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        } else {

            int[] start = new int[intervals.length];
            int[] end = new int[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i].start;
                end[i] = intervals[i].end;
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int sIdx = 0;
            int eIdx = 0;
            int count = 0;
            int maxCount = 0;

            while (sIdx < intervals.length) {
                if (end[eIdx] <= start[sIdx]) {
                    maxCount = Math.max(maxCount, count);
                    eIdx++;
                    count--;
                } else if (end[eIdx] > start[sIdx]) {
                    sIdx++;
                    count++;
                }
            }

            return Math.max(maxCount, count);
        }
    }
}
