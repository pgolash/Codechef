package Design.Practice.ParkingLot;

import java.util.Map;

/**
 * Created by prashantgolash on 8/20/15.
 */
public class MultiFloorParkingSystem implements IParkingSystem {

    private ParkingFloor[] parkingFloors;
    private Map<IVehicle, ParkingSlot> parkedVehicles;
    private static final double DEFAULT_PARKING_RATE_HOUR = 3;
    private static final int DEFAULT_NUM_PARKING_FLOORS = 5;

    private static MultiFloorParkingSystem multiFloorParkingSystem = null;

    private MultiFloorParkingSystem(int numFloors) {

        // allocate slots of each parking type according to requirement
        int


    }


    public static MultiFloorParkingSystem getInstance() {

        if (multiFloorParkingSystem == null) {
            multiFloorParkingSystem = new MultiFloorParkingSystem();
        }

        return multiFloorParkingSystem;

    }


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
        slot.setCurrentVehicleEnterTime(currTime);
    }

    public void unParkAction(IVehicle v) {
        long currTime = System.currentTimeMillis();
        ParkingSlot slot = parkedVehicles.get(v);

        if (slot != null) {
            slot.setOccupied(false);
            slot.setCurrentVehicleExitTime(currTime);
        }
    }

    public double getCharging(IVehicle v) {
        return ((v.getExitTime() - v.getEnterTime()) / 1000 * 60 * 60) % 24 * PARKING_RATE_HOUR;
    }
}
