package Design.Practice.ParkingLot;

import java.util.Objects;

/**
 * Created by prashantgolash on 8/20/15.
 */
public class GeneralVehicle implements IVehicle {

    private String registrationNumber;
    private long enterTime;
    private long exitTime;
    private MultiFloorParkingSystem parkingSystem;


    @Override
    public long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(long enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }


    public void park(ParkingType type) {
        ParkingSlot slot = parkingSystem.getParking(type);
        if (slot != null) {
            parkingSystem.parkAction(this, slot);
        }
    }

    public void unpark() {
        parkingSystem.unParkAction(this);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals (Object o) {
        if (!( o instanceof IVehicle)) {
            return false;
        } else {
            IVehicle v = (IVehicle) o;
            return registrationNumber.equals(v.getRegistrationNumber());
        }
    }

    @Override
    public int hashCode() {
        return registrationNumber.hashCode();
    }


}
