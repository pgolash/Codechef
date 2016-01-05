package GeeksForGeeks.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by prashantgolash on 31/12/15.
 */
public class MergeKSortedIterator {
        public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
            List<Integer> result = new ArrayList<>();
            if (iterators == null || iterators.size() == 0) {
                return result;
            }

            PriorityQueue<MyIterator> pq = new PriorityQueue<>(iterators.size());

            for (Iterator<Integer> iterator : iterators) {
                if (iterator.hasNext()) {
                    pq.add(new MyIterator(iterator.next(), iterator));
                }
            }

            while (!pq.isEmpty()) {
                MyIterator curr = pq.poll();
                result.add(curr.val);
                if (curr.hasNext()) {
                    pq.add(curr);
                }
            }

            return result;
        }

        private static class MyIterator implements Comparable<MyIterator> {
            private Integer val;
            private Iterator<Integer> iterator;

            public MyIterator(Integer val, Iterator<Integer> iterator) {
                this.val = val;
                this.iterator = iterator;
            }

            public boolean hasNext() {
                if (iterator.hasNext()) {
                    val = iterator.next();
                    return true;
                }

                return false;
            }

            public int compareTo(MyIterator that) {
                return this.val - that.val;
            }
        }
    }
