package Design.Practice.Redis.DataLayer;

import java.util.Iterator;
import java.util.Set;

public interface DataStorage {
    public void storeKey(String key, String value, int version);
    public int getVersion(String key);
    public String getData(String key);
    public boolean containsKey(String key);
    public void clean();
    public Iterator<String> keyIterator();
    public Set<String> valToKeySet(String val);
    public void deleteKey(String key);
    public int getSize();
}
