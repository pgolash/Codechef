package Design.Practice.Redis.Engine;

import Design.Practice.Redis.DataLayer.DataStorage;
import Design.Practice.Redis.DataLayer.MapData;

import java.util.*;

public class RedisPersistentStoreEngine implements IPersistentStoreEngine {

    private Stack<DataStorage> _contextStack;
    private DataStorage _persistentContext;
    private DataStorage _topTransactionContext;
    private static RedisPersistentStoreEngine _instance = null;

    public void initializeContext() {
        DataStorage tempData = new MapData();
        if (_topTransactionContext != null) {
            _contextStack.push(_topTransactionContext);
        }
        _topTransactionContext = tempData;
    }


    private RedisPersistentStoreEngine() {
        _persistentContext = new MapData();
        _contextStack = new Stack<>();
        _topTransactionContext = null;
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
                numEqualsTo(tokenizers[1], isTransaction);
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


    // Singleton instance of Redis Engine
    public static RedisPersistentStoreEngine getInstance() {
        if (_instance == null) {
            _instance = new RedisPersistentStoreEngine();
        }
        return _instance;
    }

    public void set(String key, String val, boolean isTransaction) {
        if (isTransaction) {
            int persistentVersion = _persistentContext.getVersion(key);
            int localVersion = persistentVersion + 1;
            _topTransactionContext.storeKey(key, val, localVersion);
        } else {
            _persistentContext.storeKey(key, val, 0);
        }
    }

    public void unset(String key, boolean isTransaction) {
        if (isTransaction) {
            set(key, null, isTransaction);
        } else {
            _persistentContext.deleteKey(key);
        }
    }

    public void get(String key, boolean isTransaction) {
        int localVersion = -1;
        int persistentVersion = -1;
        if (isTransaction) {
            localVersion = _topTransactionContext.getVersion(key);
            persistentVersion = _persistentContext.getVersion(key);
            System.out.println(persistentVersion >= localVersion ? _persistentContext.getData(key) : _topTransactionContext.getData(key));
        } else {
            System.out.println(_persistentContext.getData(key));
        }
    }

    public void numEqualsTo(String value, boolean isTransaction) {
        if (isTransaction) {
            Set<String> localKeys = _topTransactionContext.valToKeySet(value);
            Set<String> persistentKeys = _persistentContext.valToKeySet(value);
            int cnt = 0;
            for (String lKey : localKeys) {
                if (persistentKeys.contains(lKey)) {
                    cnt++;
                    continue;
                } else {
                    int persistentVersion = _persistentContext.getVersion(lKey);
                    int localVersion = _topTransactionContext.getVersion(lKey);

                    if (localVersion > persistentVersion) {
                        cnt++;
                    }
                }
            }

            for (String pKey : persistentKeys) {
                if (!localKeys.contains(pKey)) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        } else {
            System.out.println(_persistentContext.valToKeySet(value).size());
        }


    }

    public void rollback() {
        boolean anyTransaction = false;

        while (_topTransactionContext.keyIterator().hasNext()) {
            String lKey = _topTransactionContext.keyIterator().next();
            int lVersion = _topTransactionContext.getVersion(lKey);
            int pVersion = _persistentContext.getVersion(lKey);
            if (pVersion < lVersion) {
                anyTransaction = true;
                break;
            }
        }

        if (!anyTransaction) {
            System.out.println("NO TRANSACTION");
        }
    }

    public void commit() {
        if (_topTransactionContext.getSize() == 0) {
            System.out.println("NO TRANSACTION");
        } else {
            while (_topTransactionContext.keyIterator().hasNext()) {
                String key = _topTransactionContext.keyIterator().next();
                if (_topTransactionContext.getData(key) == null) {
                    _persistentContext.deleteKey(key);
                } else {
                    int version = _persistentContext.getVersion(key);
                    _persistentContext.storeKey(key, _topTransactionContext.getData(key), version + 1);
                }
            }
        }
        _topTransactionContext.clean();
        if (!_contextStack.isEmpty()) {
            _topTransactionContext = _contextStack.pop();
        }
    }

    public void end() {
        _persistentContext.clean();
        _contextStack.empty();
    }
}