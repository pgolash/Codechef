package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/20/15.
 */
public interface IVehicle {
    public void park(ParkingType type);
    public void unpark();
    public String getRegistrationNumber();
    public long getEnterTime();
    public long getExitTime();
    public void setEnterTime(long time);
    public void setExitTime(long time);
}
