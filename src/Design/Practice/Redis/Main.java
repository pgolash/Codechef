package Design.Practice.Redis;

import Design.Practice.Redis.Engine.IPersistentStoreEngine;
import Design.Practice.Redis.Engine.RedisPersistentStoreEngine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by prashantgolash on 10/27/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        IPersistentStoreEngine _engine = RedisPersistentStoreEngine.getInstance();
        BufferedReader br = null;
        if (args.length > 1) {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String line = null;

        while ((line = br.readLine()) != null) {
            _engine.receiveCommand(line);
        }
    }
}
