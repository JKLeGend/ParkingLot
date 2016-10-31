import org.Car;
import org.ParkingLot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/20/16.
 */
public class CarTest {
    @Test
    public void testCar() {
        ParkingLot parkingLot = new ParkingLot("east", 10);
        Car benz = new Car();
        assertEquals(10, benz.checkParkingSlot(parkingLot));
    }

    @Test
    public void testCarParkWhenParkingLotAvailable() throws Exception {
        ParkingLot parkingLot = new ParkingLot("east", 10);
        Car benz = new Car();
        assertEquals(1, benz.park(parkingLot).checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testCarParkWhenParkingLotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot("east", 1);
        Car benz = new Car();
        Car audi = new Car();
        benz.park(parkingLot);
        audi.park(parkingLot);
    }

    @Test
    public void testCarLeaveWhenFindInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot("east", 10);
        Car benz = new Car();
        benz.park(parkingLot);
        assertEquals(0, benz.leave(parkingLot).checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testCarLeaveWhenNotFindInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot("east", 10);
        Car benz = new Car();
        Car audi = new Car();
        benz.park(parkingLot);
        audi.leave(parkingLot);
    }
}
