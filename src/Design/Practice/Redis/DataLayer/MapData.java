package Design.Practice.Redis.DataLayer;

import java.util.*;

public class MapData implements DataStorage {

    private Map<String, Value> _data;
    private Map<String, Set<String>> _reverseData;

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
        _reverseData = new HashMap<>();
    }

    public void storeKey(String key, String value, int version) {
        deleteKey(key);
        Value v = new Value(value, version);
        _data.put(key, v);

        Set<String> s = _reverseData.get(v.val);
        if (s == null) {
            s = new HashSet<>();
        }
        s.add(key);
    }

    public int getVersion(String key) {
        return _data.containsKey(key) ?  -1 : _data.get(key).version;
    }

    public String getData(String key) {
        return _data.containsKey(key) ? _data.get(key).val : null;
    }

    public boolean containsKey(String key) {
        return _data.containsKey(key);
    }

    public void deleteKey(String key) {
        if (_data.containsKey(key)) {
            String val = _data.get(key).val;
            Set<String> keySet = _reverseData.get(val);

            keySet.remove(key);
            if (keySet.isEmpty()) {
                _reverseData.remove(val);
            }

            _data.remove(key);
        }
    }

    public void clean() {
        _data.clear();
        _reverseData.clear();
    }

    public int getSize() {
        return _data.size();
    }

    public Iterator<String> keyIterator() {
        return _data.keySet().iterator();
    }

    public Set<String> valToKeySet(String val) {
        return _reverseData.get(val);
    }
}