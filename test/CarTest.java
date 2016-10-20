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
        Car car = new Car(new ParkingLot(10));
        assertEquals(10, car.checkParkingSlot());
    }

    @Test
    public void testCarParkWhenParkingLotAvailable() throws Exception {
        Car car = new Car(new ParkingLot(10));
        assertEquals(1, car.park().checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testCarParkWhenParkingLotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car(parkingLot);
        Car car2 = new Car(parkingLot);
        car1.park();
        car2.park();
    }

    @Test
    public void testCarLeaveWhenFindInParkingLot() throws Exception {
        Car car = new Car(new ParkingLot(10));
        car.park();
        assertEquals(0, car.leave().checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testCarLeaveWhenNotFindInParkingLot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car(parkingLot);
        Car car2 = new Car(parkingLot);
        car1.park();
        car2.leave();
    }
}
