package Design.Practice.WebServer;

import com.sun.net.httpserver.HttpServer;

import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * Created by prashantgolash on 9/13/15.
 */
public class CallableImpl<V> implements Callable<V>{
    CallableImpl(SocialHttpServer s) {


    }

    public V call() {
        V t = null;

        return t;
    }
}
