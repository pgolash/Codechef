package Design.Practice.Redis.Engine;

/**
 * Created by prashantgolash on 10/26/15.
 */
public interface IPersistentStoreEngine {
    public void executeCommand(String command) throws UnsupportedOperationException;
    public void set(String key, String val, boolean isTransaction);
    public void unset(String key, boolean isTransaction);
    public String get(String key, boolean isTransaction);
    public void rollback();
    public void commit();
}
