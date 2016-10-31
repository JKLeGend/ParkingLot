package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/30/16.
 */
public class Manager {
    private String name;
    protected ArrayList<ParkingLot> parkingLots;

    public Manager(String name){
      this.name = name;
    }

    public void manage(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public boolean park(Car car) throws Exception {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.isAvailable()) {
                car.park(parkingLot);
                return true;
            } else {
                throw new Exception();
            }
        }
        return true;
    }

    public boolean fetch(Car car) throws Exception {
        int empty = 0;
        for(ParkingLot parkingLot: parkingLots){
            try{
                car.leave(parkingLot);
            } catch(Exception e)  {
                empty++;
            }
        }

        if (empty == parkingLots.size()) {
            throw new Exception();
        }

        return true;
    }

    public ArrayList<ParkingLot> getLots() {
        return this.parkingLots;
    }

    public String getName() {
        return this.name;
    }
}
