package LeetCode.Intervals;

import java.util.*;

/**
 * Created by prashantgolash on 8/30/15.
 */
public class MergeIntervals {

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

    class C implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start < i2.start) {
                return -1;
            } else if (i1.start == i2.start) {
                if (i1.end < i2.end) {
                    return -1;
                } else if (i1.end == i2.end) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> myList = new ArrayList<>();
        if (intervals == null) {
            return null;
        } else if (intervals.size() == 0) {
            return intervals;
        } else {
            C c = new C();
            intervals.sort(c);

            Stack<Interval> myStack = new Stack<Interval>();
            myStack.push(intervals.get(0));

            for (int i = 1; i < intervals.size(); i++) {
                if (isIntersecting(myStack.peek(), intervals.get(i))) {
                    Interval temp = mergeIntervals(myStack.pop(), intervals.get(i));
                    myStack.push(temp);
                } else {
                    myStack.push(intervals.get(i));
                }
            }


            while (!myStack.empty()) {
                myList.add(myStack.pop());
            }

            reverse(myList);
            return myList;
        }
    }

    public <E> void reverse(List<E> myList) {
        int middle = (myList.size() - 1) / 2;
        for (int i = 0; i <= middle; i++) {
            E temp = myList.get(myList.size() - 1 - i);
            myList.set(myList.size() - 1 - i, myList.get(i));
            myList.set(i, temp);
        }
    }
}