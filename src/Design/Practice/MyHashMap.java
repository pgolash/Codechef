package Design.Practice;

import java.util.Iterator;

/**
 * Created by prashantgolash on 24/02/16.
 */
public interface MyHashMap<K,V> {
    public V get(K key);
    public boolean containsValue(V v);
    public V put(K key, V v);
    public boolean containsKey(K key);
    public Iterator<K> keySet();
    public Iterator<V> values();
}

class MyHashMapImpl<K,V> implements MyHashMap<K,V> {

    private Node[] nodes;
    private final int defaultCapacity = 10;
    private int currSize = 10;

    public MyHashMapImpl() {
        nodes = new Node[defaultCapacity];
    }

    // internal
    public void grow() {

    }

    public boolean full() {
        return true;
        // some threshold

    }

    public int size() {
        return currSize;
    }

    class Node<K,V> {
        Node<K,V> next;
        int hashCode;
        K key;
        V val;

        public Node(K k, V v, int hashCode, Node<K,V> next) {
            this.key = k;
            this.val = v;
            this.hashCode = hashCode;
            this.next = next;
        }
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsValue(V v) {
        return false;
    }

    @Override
    public V put(K key, V v) {

        if (full()) {
            grow();
        }

        int hashCode = key.hashCode();
        int index = (hashCode % size());
        V oldval = null;

        Node<K,V> e = nodes[index];
        Node<K,V> prev = null;

        while (e != null) {
            if (e.hashCode == key.hashCode() && e.key.equals(key)) {
                oldval = e.val;
                e.val = v;
                return oldval;
            }
            prev = e;
            e = e.next;
        }

        e = new Node<>(key, v, hashCode, null);

        if (prev != null) {
            prev.next = e;
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public Iterator<K> keySet() {
        return null;
    }

    @Override
    public Iterator<V> values() {
        return null;
    }
}