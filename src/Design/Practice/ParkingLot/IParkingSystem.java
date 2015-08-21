package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/20/15.
 */

public interface IParkingSystem {
    public ParkingSlot getParking(ParkingType pType);
    public void parkAction(IVehicle v, ParkingSlot slot);
    public void unParkAction(IVehicle v);
    public double getCharging(IVehicle v);
}