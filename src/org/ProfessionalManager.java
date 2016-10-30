package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManager extends SmartManager{
    private ArrayList<Manager> managers;

    public void manage(ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots) {
        this.managers = managers;
        this.parkingLots = parkingLots;
    }

    public void park(Manager manager, Car car) throws Exception {
        int index = managers.indexOf(manager);
        if(index >= 0) {
            manager.park(car);
        } else {
            throw new Exception("No authority!");
        }
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
