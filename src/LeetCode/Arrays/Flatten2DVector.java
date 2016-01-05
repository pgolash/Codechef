package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 30/12/15.
 */
public class Flatten2DVector {

    private Iterator<List<Integer>> lIter = null;
    private Iterator<Integer> currIter = null;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        lIter = vec2d.iterator();
        if (lIter.hasNext()) {
            currIter = lIter.next().iterator();
        }
    }

    public int next() {
        return currIter.next();
    }

    public boolean hasNext() {
        boolean b = false;
        if (currIter != null) {
            b = currIter.hasNext();
            if (!b) {
                while (lIter.hasNext()) {
                    currIter = lIter.next().iterator();
                    if (currIter.hasNext()) {
                        b = true;
                        break;
                    }
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
    }
}
