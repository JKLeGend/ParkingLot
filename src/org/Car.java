package org;

/**
 * Created by jukzhang on 10/20/16.
 */
public class Car implements Action{

    public Car() {}

    public ParkingLot park(ParkingLot parkingLot) throws Exception {
        parkingLot.registerCar(this);
        return parkingLot;
    }

    public ParkingLot leave(ParkingLot parkingLot) throws Exception {
        parkingLot.removeCar(this);
        return parkingLot;
    }

    public int checkParkingSlot(ParkingLot parkingLot) {
        return parkingLot.getSlot();
    }
}
