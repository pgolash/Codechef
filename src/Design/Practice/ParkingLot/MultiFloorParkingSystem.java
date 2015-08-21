package Design.Practice.ParkingLot;

import java.util.Map;

/**
 * Created by prashantgolash on 8/20/15.
 */
public class MultiFloorParkingSystem implements IParkingSystem {

    private ParkingFloor[] parkingFloors;
    private Map<IVehicle, ParkingSlot> parkedVehicles;
    private static final double PARKING_RATE_HOUR = 3;

    public ParkingSlot getParking(ParkingType pType) {
        ParkingSlot slot = null;
        for (int floor = 0; floor < parkingFloors.length; floor++) {
            if ((slot = parkingFloors[floor].getFreeSlot(pType)) != null) {
                return slot;
            }
        }
        return null;
    }

    public void parkAction(IVehicle v, ParkingSlot slot) {
        parkedVehicles.put(v, slot);

        slot.setOccupied(true);
        long currTime = System.currentTimeMillis();
        v.setEnterTime(currTime);
    }

    public void unParkAction(IVehicle v) {
        long currTime = System.currentTimeMillis();
        ParkingSlot slot = parkedVehicles.get(v);

        if (slot != null) {
            slot.setOccupied(false);
        }

        v.setExitTime(currTime);
    }

    public double getCharging(IVehicle v) {
        return ((v.getExitTime() - v.getEnterTime()) / 1000 * 60 * 60) % 24 * PARKING_RATE_HOUR;
    }
}
