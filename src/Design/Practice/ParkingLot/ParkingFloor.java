package Design.Practice.ParkingLot;

import java.util.Map;

/**
 * Created by prashantgolash on 8/21/15.
 */
/*

 */
public class ParkingFloor {
    private ParkingSlot[] slots;
    private Integer floorNumber;

    ParkingFloor(Map<ParkingType, Integer> parkingTypeToCount, Integer floorNumber) {
        this.floorNumber = floorNumber;

        // initialize all slot here
        int idx = 0;
        int cnt = 0;

        for (Map.Entry<ParkingType, Integer> entry : parkingTypeToCount.entrySet()) {
            cnt += entry.getValue();
        }

        slots = new ParkingSlot[cnt];

        for (Map.Entry<ParkingType, Integer> entry : parkingTypeToCount.entrySet()) {

            ParkingType type = entry.getKey();

            for (int currIdx = 1; currIdx <= entry.getValue(); currIdx++) {
                slots[idx++] = new ParkingSlot(floorNumber, type);
            }
        }
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