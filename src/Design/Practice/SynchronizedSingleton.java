package Design.Practice;

/**
 * Created by prashantgolash on 28/01/16.
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance = null;
    private static Object monitor = new Object();

    private SynchronizedSingleton() {

    }

    public static SynchronizedSingleton getInstance() {
        if (instance != null) {
            return instance;
        } else {
            synchronized (monitor) {
                if (instance != null) {
                    return instance;
                } else {
                    instance = new SynchronizedSingleton();
                    return instance;
                }
            }
        }
    }
}
