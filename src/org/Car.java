package org;

/**
 * Created by jukzhang on 10/20/16.
 */
public class Car implements Action{
    private ParkingLot parkingLot;

    public Car(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot park() throws Exception {
        parkingLot.registerCar(this);
        return parkingLot;
    }

    public ParkingLot leave() throws Exception {
        parkingLot.removeCar(this);
        return parkingLot;
    }

    public int checkParkingSlot() {
        return this.parkingLot.getSlot();
    }
}
