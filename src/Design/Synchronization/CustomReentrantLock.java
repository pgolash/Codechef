package Design.Synchronization;

/**
 * Created by prashantgolash on 19/01/16.
 */
public class CustomReentrantLock {
    boolean isLocked = false;
    Thread owningThread = null;
    int numLock = 0;

    public synchronized void lock() throws Exception {
        while (checkCond()) {
            wait();
        }

        isLocked = true;
        owningThread = Thread.currentThread();
        numLock++;

    }

    public synchronized void unlock() throws Exception {
        if (owningThread == Thread.currentThread()) {
            numLock--;
            if (numLock == 0) {
                isLocked = false;
                notifyAll();
            }
        }
    }

    public boolean checkCond() {
        if (Thread.currentThread() == owningThread) {
            return true;
        } else {
            return isLocked;
        }
    }
}
