import org.Car;
import org.ParkingLot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void testParkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertEquals(10, parkingLot.getSlot());
    }

    @Test
    public void testRegisterCarParkingLotAvailable() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car benz = new Car();
        parkingLot.registerCar(benz);

        assertEquals(1, parkingLot.getSlot());
    }

    @Test(expected = Exception.class)
    public void testRegisterCarParkingLotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car benz = new Car();
        Car audi = new Car();
        parkingLot.registerCar(benz);
        parkingLot.registerCar(audi);
    }

    @Test
    public void testRemoveCarInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car benz = new Car();
        parkingLot.registerCar(benz);
        parkingLot.removeCar(benz);

        assertEquals(0, parkingLot.getSlot());
    }

    @Test(expected = Exception.class)
    public void testRemoveCarNotInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car benz = new Car();
        Car audi = new Car();
        parkingLot.registerCar(benz);
        parkingLot.removeCar(audi);
    }

    @Test
    public void testParkingLotIsAvailable() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        Car benz = new Car();
        Car audi = new Car();
        parkingLot.registerCar(benz);
        parkingLot.registerCar(audi);

        assertEquals(false, parkingLot.isAvailable());
    }

    @Test
    public void testAvailableParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        Car benz = new Car();
        parkingLot.registerCar(benz);

        assertEquals(1, parkingLot.getAvailableSlot());
    }

}