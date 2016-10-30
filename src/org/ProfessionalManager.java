package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManager {
    private ArrayList<Manager> managers;
    private ArrayList<ParkingLot> parkingLots;

    public void manage(ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots) {
        this.managers = managers;
        this.parkingLots = parkingLots;
    }

    public int getManagers() {
        return managers.size();
    }

    public int getParkingLots() {
        return managers.size();
    }
}
