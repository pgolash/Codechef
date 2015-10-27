package Design.Practice.Redis.DataLayer;

import java.util.Iterator;

/**
 * Created by prashantgolash on 10/26/15.
 */
public interface DataStorage {
    public void storeKey(String key, String value, int version);
    public void deleteKey(String key);
    public int getVersion(String key);
    public String getData(String key);
    public void clean();
    public Iterator<String> keyIterator();
}
