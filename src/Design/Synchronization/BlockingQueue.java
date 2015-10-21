package Design.Synchronization;

import LeetCode.Arrays.ExcelToColumnNumber;

/**
 * Created by prashantgolash on 10/14/15.
 */
public class BlockingQueue<T> {
    private T data[];
    private int produceIndex;
    private int consumeIndex;
    private int queueSize;
    private int size;

    BlockingQueue(int size) {
        this.data = (T[]) new Object[size];
        this.produceIndex = this.consumeIndex = -1;
        this.size = size;
        this.queueSize = 0;
    }

    public T consume() {
        synchronized (this) {
            while(queueSize == 0) {
                try {
                    this.wait();
                } catch(Exception e) {

                }
            }

            consumeIndex = (consumeIndex + 1) % size;
            queueSize--;
            T elem = data[consumeIndex];
            this.notifyAll();
            return elem;
        }
    }

    public boolean produce(T elem)  {
        synchronized (this) {
            while (queueSize == size) {
                try {
                    this.wait();
                } catch(Exception e) {

                }
            }

            queueSize++;
            produceIndex = (produceIndex + 1) % size;
            data[produceIndex] = elem;
            this.notifyAll();
            return true;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> q = new BlockingQueue<Integer>(5);
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Consumer consumed : " + q.consume());
                }
            }

        };

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                int cnt = 1;
                while (true) {
                    System.out.println("Producer produced : " + cnt);
                    q.produce(cnt);
                    cnt++;
                }
            }
        };

        Thread c = new Thread(consumer);
        Thread p = new Thread(producer);
        c.start();
        p.start();
    }
}