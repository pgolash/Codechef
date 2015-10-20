package Design.Synchronization;

/**
 * Created by prashantgolash on 10/19/15.
 */
public class ReadWriteLock {
    private int writers;
    private int writeRequests;
    private int readers;

    ReadWriteLock() {
        writeRequests = writers = readers = 0;
    }

    public synchronized void lockRead() throws InterruptedException {
        while (writeRequests > 0 || writers > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead() throws InterruptedException {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        if (readers > 0 || writers > 0) {
            wait();
        }

        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }
}
