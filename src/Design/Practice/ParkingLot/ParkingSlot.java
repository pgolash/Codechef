package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/21/15.
 */
public class ParkingSlot {
    private final int floorNumber;
    private boolean isOccupied;
    private final ParkingType parkingType;

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean getOccupied() {
        return isOccupied;
    }

    ParkingSlot(int floorNumber, ParkingType pType) {
        this.floorNumber = floorNumber;
        this.isOccupied = false;
        this.parkingType = pType;
    }
}
