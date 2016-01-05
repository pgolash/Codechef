package Design.Synchronization;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prashantgolash on 31/12/15.
 */
public class BlockingQueueStandard<T> {
    private Queue<T> queue;
    private int capacity = 10;

    // Constructor
    public BlockingQueueStandard(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    // Add the given element to the end of the queue,
    // Waiting if necessary for space to become available
    public synchronized void put(T obj)
            throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(obj);
        notifyAll();
    }

    // Retrive and remove the head of the queue,
    // waiting if no elements are present
    public synchronized T take()
            throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }

        T obj = queue.poll();
        notifyAll();

        return obj;
    }
}
