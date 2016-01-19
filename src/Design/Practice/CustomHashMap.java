package Design.Practice;

import LeetCode.Tree.IterativeInorderTraversal;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by prashantgolash on 14/01/16.
 */
public class CustomHashMap <K, V> {

    private Entry[] entryList;
    private final int DEFAULT_CAPACITY = 10;

    class Entry<K,V> {
        private K key;
        private V val;
        private Entry<K,V> entry;
        private Entry<K,V> head;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;

        }

        public V getVal() {
            return val;
        }

        public K getKey() {
            return key;
        }

        public Iterator<Entry<K, V>> getIterator() {
            return new EntryIterator<>();
        }

        class EntryIterator<K,V> implements Iterator<Entry<K,V>> {
            private Entry<K, V> currHead;

            public EntryIterator() {
                currHead = (Entry<K,V>)head;
            }

            @Override
            public boolean hasNext() {
                return currHead != null;
            }

            @Override
            public Entry<K, V> next() {
                Entry<K, V> e = currHead;
                currHead = currHead.entry;
                return e;
            }
        }
    }


    public CustomHashMap() {
        // first hash and then key locator
        // now

    }

    public CustomHashMap(int size) {
        // first hash and then key locator
        // now traverse till now found equals

    }

    public void resize() {

    }

    public int size() {
        return entryList.length;
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int idx = hashCode % entryList.length;
        Entry<K,V> e = entryList[idx];

        while(e.getIterator().hasNext()) {

        }

        return null;
    }

    public void put(K key, V v) {
        // done
    }

    public Set<K> keySet() {
        // iterate through entry list and accumulate keys
        return null;
    }

    public List<V> values() {
        // iterate through values and accumalate val
        return null;
    }
}