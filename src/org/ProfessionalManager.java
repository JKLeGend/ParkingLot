package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManager extends SmartManager {
    private ArrayList<Manager> managers;

    public ProfessionalManager(String name) {
        super(name);
    }

    public void manage(ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots) {
        this.managers = managers;
        this.parkingLots = parkingLots;
    }

    public void park(Manager manager, Car car) throws Exception {
        int index = managers.indexOf(manager);
        if (index >= 0) {
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

    public void report() {
        System.out.print(this.getName());
        System.out.println("直属管理的停车场:");
        for (int i = 0; i < parkingLots.size(); i++) {
            System.out.println(parkingLots.get(i).getName());
        }
        System.out.println("管家及管理的停车场情况:");
        for (int i = 0; i < managers.size(); i++) {
            System.out.println(managers.get(i).getName());
            if (managers.get(i).getLots() != null) {
                for (int j = 0; j < managers.get(i).getLots().size(); j++) {
                    ParkingLot parkingLot = managers.get(i).getLots().get(j);
                    System.out.println(parkingLot.getName());
                    System.out.print("总共:");
                    System.out.print(parkingLot.getSlot());
                    System.out.print(" 已停");
                    System.out.print(parkingLot.checkParkStatus());
                    System.out.print(" 剩余");
                    System.out.println(parkingLot.getAvailableSlot());
                }
            } else {
                System.out.println("无");
            }

        }
    }
}
