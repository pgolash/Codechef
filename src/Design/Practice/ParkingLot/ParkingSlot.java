package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/21/15.
 */
public class ParkingSlot {
    private final int floorNumber;
    private boolean isOccupied;
    private final ParkingType parkingType;
    private long currentVehicleEnterTime;
    private long currentVehicleExitTime;

    public long getCurrentVehicleEnterTime() {
        return currentVehicleEnterTime;
    }

    public void setCurrentVehicleEnterTime(long currentVehicleEnterTime) {
        this.currentVehicleEnterTime = currentVehicleEnterTime;
    }

    public long getCurrentVehicleExitTime() {
        return currentVehicleExitTime;
    }

    public void setCurrentVehicleExitTime(long currentVehicleExitTime) {
        this.currentVehicleExitTime = currentVehicleExitTime;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean getOccupied() {
        return isOccupied;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    ParkingSlot(int floorNumber, ParkingType pType) {
        this.floorNumber = floorNumber;
        this.isOccupied = false;
        this.parkingType = pType;
        this.currentVehicleEnterTime = -1;
    }
}