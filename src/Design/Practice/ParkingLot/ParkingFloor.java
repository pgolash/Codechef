package Design.Practice.ParkingLot;

/**
 * Created by prashantgolash on 8/21/15.
 */
public class ParkingFloor {
    private ParkingSlot[] slots;

    ParkingFloor() {

    }

    public ParkingSlot getFreeSlot(ParkingType type) {

        for (ParkingSlot slot : slots) {
            if (slot.getOccupied() == false && slot.getParkingType() == type) {
                return slot;
            }
        }

        return null;
    }
}