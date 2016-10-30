package org;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jukzhang on 10/30/16.
 */
public class SmartManager extends Manager{
    @Override
    public boolean park(Car car) throws Exception {
        ParkingLot tmParkingLot = parkingLots.get(0);

        for(int index = 0; index < parkingLots.size() - 1; index++) {
            if(parkingLots.get(index).getAvailableSlot() < parkingLots.get(index + 1).getAvailableSlot())
                tmParkingLot = parkingLots.get(index + 1);
        }
        car.park(tmParkingLot);

        return true;
    }
}
