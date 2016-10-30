package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/30/16.
 */
public class Manager {
    private ArrayList<ParkingLot> parkingLots;

    public void manage(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public boolean park(Car car) throws Exception {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.isAvailable()) {
                car.park(parkingLot);
                return true;
            }
        }
        return false;
    }

    public int getLots() {
        return this.parkingLots.size();
    }
}
