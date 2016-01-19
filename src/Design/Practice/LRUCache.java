package Design.Practice;

import java.util.HashMap;
import java.util.Map;

class Node<K> {
    K key;
    Node<K> next;
    Node<K> prev;

    Node(K key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    Node() {
        this.next = null;
        this.prev = null;
    }
}

class Data<V> {
    V value;
    Node pointerToKeyNode;
    Data(V val, Node n) {
        this.value = val;
        this.pointerToKeyNode = n;
    }
}

public class LRUCache<K, V> {

    private Map<K, Data<V>> cache;
    private Node<K> head;
    private Node<K> last;
    private int size;


    public LRUCache(int maxSize) {
        cache = new HashMap<>();
        head = new Node<>();
        last =  new Node<>();
        head.next = last;
        last.prev = head;
        size = maxSize;
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Data<V> d = cache.get(key);
            V v = d.value;
            updateTime(d.pointerToKeyNode);
            return v;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Data<V> d = cache.get(key);
            d.value = value;
            updateTime(d.pointerToKeyNode);
        } else {
            if (cache.keySet().size() == size) {
                // sure that this is last accessed
                K k = head.next.key;
                cache.remove(k);
                deleteLRU();
            }
            Node<K> n = insertNewNode(key);
            cache.put(key, new Data(value, n));
        }
    }

    public void deleteLRU() {
        // head.next is pointing to first node
        head.next = head.next.next;
        head.next.prev = head;
    }

    public Node<K> insertNewNode(K key) {
        Node<K> newNode = new Node(key);

        // x(data last node) last(dummy)
        newNode.next = last;
        last.prev.next = newNode;
        newNode.prev = last.prev;
        last.prev = newNode;


        return newNode;
    }

    public void updateTime(Node<K> pointerNode) {
        // adjusting the pointerNode

        // x pointerNode y
        // essential delete the pointerNode
        pointerNode.prev.next = pointerNode.next;
        pointerNode.next.prev = pointerNode.prev;


        // moving pointerNode to last
        pointerNode.next = last;
        last.prev.next = pointerNode;
        pointerNode.prev = last.prev;
        last.prev = pointerNode;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> c = new LRUCache<>(3);
        c.put(5, 6);
        c.put(3, 6);
        c.put(4, 6);
        c.put(7, 6);
        c.put(3, 7);
        c.put(8, 7);
        System.out.println(c.get(3));

    }
}