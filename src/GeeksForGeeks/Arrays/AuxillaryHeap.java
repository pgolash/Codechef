package GeeksForGeeks.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by prashantgolash on 17/12/15.
 */
public class AuxillaryHeap<T> extends BinaryHeap<T> {
    private Map<T, Integer> elemToKey = null;

    public AuxillaryHeap() {
        elemToKey = new HashMap<>();
    }

    public boolean remove(T e) {
        if (!elemToKey.containsKey(e)) {
            return false;
        } else {
            int idx = elemToKey.get(e);
            elemToKey.remove(idx);
            super.remove(idx);
            return true;
        }
    }

    public int add(T elem) {
        int d = super.add(elem);
        elemToKey.put(elem, d);
        return d;
    }
}
