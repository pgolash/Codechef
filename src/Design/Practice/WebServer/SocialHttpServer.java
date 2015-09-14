package Design.Practice.WebServer;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by prashantgolash on 8/31/15.
 */

public class SocialHttpServer {

    private static final int port = 1100;
    private ServerSocket _socket = null;
    private ExecutorService _executorService = null;
    private final Map<String, HttpHandler> _handlers;

    SocialHttpServer() throws Exception {
        _socket = new ServerSocket(port);
        _executorService = Executors.newFixedThreadPool(10);
        _handlers =  new HashMap<>();

        HttpHandler tweetHandler = new TweetHandler();
        HttpHandler facebookHandler = new FacebookHandler();

        _handlers.put("/tweet", tweetHandler);
        _handlers.put("/facebook", facebookHandler);
    }

    public Map getHandlers() {
        return _handlers;
    }

    public void start() throws Exception {

        while (true) {
            Socket s = _socket.accept();
            CallableImpl<String> c = new CallableImpl<>(this);
            Future<String> f = _executorService.submit(c);
        }
    }

    public static void main(String[] args) {
        try {
            SocialHttpServer serv = new SocialHttpServer();
            serv.start();
        } catch (Exception e) {
            System.out.println("test");
        }

    }
}