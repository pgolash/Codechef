package Design.Practice.Redis;

import Design.Practice.Redis.Engine.IPersistentStoreEngine;
import Design.Practice.Redis.Engine.RedisPersistentStoreEngine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        IPersistentStoreEngine _engine = RedisPersistentStoreEngine.getInstance();
        BufferedReader br;
        if (args.length > 1) {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String command;
        while ((command = br.readLine()) != null) {
            _engine.executeCommand(command);
        }
    }
}
