package org;

import java.util.ArrayList;

/**
 * Created by jukzhang on 10/20/16.
 */
public class ParkingLot implements Management{
    public ArrayList<Car> cars = new ArrayList<>();
    private int slotNumber;

    public ParkingLot(int slot) {
        this.slotNumber = slot;
    }

    public void registerCar(Car car) throws Exception {
        if(isAvailable()) {
            cars.add(car);
        } else {
            throw new Exception("ParkingLot is full!");
        }
    }

    public void removeCar(Car car)  throws Exception {
        int index = cars.indexOf(car);
        if(index >= 0) {
            cars.remove(index);
        } else {
            throw new Exception("Can't find your car!");
        }
    }

    public boolean isAvailable() {
        return cars.size() < this.slotNumber;
    }

    public int getSlot() {
        return this.slotNumber;
    }

    public int getAvailableSlot() {
        return this.slotNumber - cars.size();
    }


    public int checkParkStatus() {
        return this.cars.size();
    }
}
