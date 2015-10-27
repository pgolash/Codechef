package Design.Practice.Redis.Engine;

import Design.Practice.Redis.DataLayer.MapData;

import java.util.Stack;

/**
 * Created by prashantgolash on 10/26/15.
 */
public class RedisPersistentStoreEngine implements IPersistentStoreEngine {

    private Stack<MapData> _contextStack;
    private MapData _persistentData;
    private MapData _topContext;
    private static RedisPersistentStoreEngine _instance = null;

    public void initializeContext() {
        MapData tempData = new MapData();
        _contextStack.push(_topContext);
        _topContext = tempData;
    }


    private RedisPersistentStoreEngine() {
        _persistentData = new MapData();
        _contextStack = null;
        _topContext = null;
    }

    public void executeCommand(String command) throws UnsupportedOperationException {
        String[] tokenizers = command.split(" ");
        boolean isTransaction = !_contextStack.isEmpty();
        switch(tokenizers[0]) {
            case "SET":
                set(tokenizers[1], tokenizers[2], isTransaction);
                break;
            case "UNSET":
                unset(tokenizers[1], isTransaction);
                break;
            case "GET":
                get(tokenizers[1], isTransaction);
                break;
            case "NUMEQUALTO":
                break;
            case "BEGIN":
                initializeContext();
                break;
            case "COMMIT":
                commit();
                break;
            case "ROLLBACK":
                rollback();
                break;
            case "END":
                end();
                break;
            default:
                throw new UnsupportedOperationException("operation not supported");
        }
    }

    public static RedisPersistentStoreEngine getInstance() {
        if (_instance == null) {
            _instance = new RedisPersistentStoreEngine();
        }
        return _instance;
    }

    public void set(String key, String val, boolean isTransaction) {
        int localVersion = -1;
        if (isTransaction) {
            int persistentVersion = _persistentData.getVersion(key);
            localVersion = persistentVersion + 1;
            _topContext.storeKey(key, val, localVersion);
        } else {
            _persistentData.storeKey(key, val, -1);
        }
    }

    public void unset(String key, boolean isTransaction) {
        set(key, null, isTransaction);
    }

    public String get(String key, boolean isTransaction) {
        int localVersion = -1;
        int persistentVersion = -1;
        if (isTransaction) {
            localVersion = _topContext.getVersion(key);
            persistentVersion = _persistentData.getVersion(key);
            if (persistentVersion >= localVersion) {
                return _persistentData.getData(key);
            } else {
                return _topContext.getData(key);
            }
        } else {
            return _persistentData.getData(key);
        }
    }

    public String numEqualTo(String value, boolean isTransaction) {
        int localVersion = -1;
        int persistentVersion = -2;
        if (isTransaction) {
        } else {
        }
    }

    public void rollback() {
        _topContext.clean();
    }

    public void commit() {
        while(_topContext.keyIterator().hasNext()) {
            String key = _topContext.keyIterator().next();
            int version = _persistentData.getVersion(key);
            _persistentData.storeKey(key, _topContext.getData(key), version + 1);
        }
    }

    public void end() {

    }
}
