package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by prashantgolash on 9/20/15.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);

        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(1, 1);
        cache.set(4, 4);

        // 1,2,3
        // 2,3,1
        // 3,1,4

        System.out.println(cache.get(4));
    }

    class Node {
        int key;
        Node next;
        Node prev;

        Node() {
            this.next = null;
            this.prev = null;
        }

        Node(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    class Data {
        int value;
        Node node;

        Data(int val, Node node) {
            this.value = val;
            this.node = node;
        }
    }

    private Map<Integer, Data> _dataMap;
    private Node _head;
    private Node _last;
    private int _currSize;
    private int _capacity;

    // get : if key is not present return nothing
    // if key is present forward the node to front


    // set if cache is full remove the first node
    // add new node to end

    // use map for <key, address> of the node

    public LRUCache(int capacity) {
        _dataMap = new HashMap<>();
        _head = _last = null;
        _currSize = 0;
        _capacity = capacity;
    }

    public int get(int key) {
        int answer = -1;
        if (_dataMap.containsKey(key)) {
            answer = _dataMap.get(key).value;
            // Update access time of the key
            adjustAccessedNode(_dataMap.get(key).node);
        }

        return answer;
    }

    public void adjustAccessedNode(Node currNode) {
        // bring node to the end
        if (currNode != _last) {
            if (currNode == _head) {
                _head = currNode.next;
                _head.prev = null;
            } else {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
            }

            _last.next = currNode;
            currNode.prev = _last;
            currNode.next = null;
            _last = currNode;
        }
    }

    public void set(int key, int value) {
        if (_dataMap.containsKey(key)) {
            _dataMap.get(key).value = value;
            adjustAccessedNode(_dataMap.get(key).node);
        } else {
            // cache is full
            if (_currSize == _capacity) {
                // evict head node
                _dataMap.remove(_head.key);
                _head = _head.next;
                _currSize--;
            }

            Node newNode = new Node(key);
            if (_head == null) {
                _head = _last = newNode;
            } else {
                _last.next = newNode;
                newNode.prev = _last;
                _last = newNode;
            }

            // Put the node in the map
            _dataMap.put(key, new Data(value, newNode));
            // Increment the size
            _currSize++;
        }
    }
}
