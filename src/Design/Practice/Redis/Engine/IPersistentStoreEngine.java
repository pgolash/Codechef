package Design.Practice.Redis.Engine;

public interface IPersistentStoreEngine {
    public void executeCommand(String command) throws UnsupportedOperationException;
    public void set(String key, String val, boolean isTransaction);
    public void unset(String key, boolean isTransaction);
    public void get(String key, boolean isTransaction);
    public void numEqualsTo(String val, boolean isTransaction);
    public void rollback();
    public void commit();
}
