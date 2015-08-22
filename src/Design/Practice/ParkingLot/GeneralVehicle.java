package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/20/15.
 */
public class GeneralVehicle implements IVehicle {

    private String registrationNumber;
    private MultiFloorParkingSystem parkingSystem;

    public void park(ParkingType type) {
        ParkingSlot slot = parkingSystem.getParking(type);
        if (slot != null) {
            parkingSystem.parkAction(this, slot);
        }
    }

    public void unpark() {
        parkingSystem.unParkAction(this);
    }

    public String registrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals (Object o) {
        if (!( o instanceof IVehicle)) {
            return false;
        } else {
            IVehicle v = (IVehicle) o;
            return registrationNumber.equals(v.registrationNumber());
        }
    }

    @Override
    public int hashCode() {
        return registrationNumber.hashCode();
    }


}
