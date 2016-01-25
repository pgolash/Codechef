package Design.Synchronization;

/**
 * Created by prashantgolash on 22/01/16.
 */
public class CustomReaderWriteLock {

    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public synchronized void readLock() throws Exception {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void writeLock() throws Exception {
        writeRequests++;
        while (writers > 0 || readers > 0) {
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void readUnlock() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    public synchronized void writeUnlock() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }

}
