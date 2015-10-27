package Design.Practice.Redis.DataLayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by prashantgolash on 10/26/15.
 */
public class MapData implements DataStorage {

    private Map<String, Value> _data;

    class Value {
        String val;
        int version;

        Value(String val,int version) {
            this.val = val;
            this.version = version;
        }
    }

    public MapData() {
        _data = new HashMap<>();
    }

    public void storeKey(String key, String value, int version) {
        if (value != null) {
            Value v = new Value(value, version);
            _data.put(key, v);
        } else {
            if (_data.containsKey(key)) {
                deleteKey(key);
            }
        }
    }

    public int getVersion(String key) {
        if (!_data.containsKey(key)) {
            return -1;
        } else {
            return _data.get(key).version;
        }
    }

    public String getData(String key) {
        if (!_data.containsKey(key)) {
            return null;
        } else {
            return _data.get(key).val;
        }
    }

    public boolean hasKey(String key) {
        return _data.containsKey(key);
    }

    public void deleteKey(String key) {
        _data.remove(key);
    }

    public void clean() {
        _data.clear();
    }

    public Iterator<String> keyIterator() {
        return _data.keySet().iterator();
    }

}
