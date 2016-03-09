package Design.Practice.WebServer;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Created by prashantgolash on 9/13/15.
 */
public class CallableImpl implements Callable {

    SocialHttpServer _server = null;
    Socket _socket = null;

    CallableImpl(SocialHttpServer s, Socket sock) {
        _server = s;
        _socket = sock;
    }

    public Object call() {
        String endPoint = _socket.getChannel().toString();
        //HttpExchange exchange = _socket.getChannel();
        HashMap<String, com.sun.net.httpserver.HttpHandler> endMap = (HashMap)_server.getHandlers();

        //endMap.get(endPoint).handle();

        return null;

    }
}
