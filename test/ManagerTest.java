import org.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ManagerTest {
    public Manager manager;
    public ArrayList<ParkingLot> parkingLots;
    @Before
    public void setUp() {
        manager = new Manager();
        parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot(1);
        ParkingLot westParkingLot = new ParkingLot(1);
        ParkingLot southParkingLot = new ParkingLot(1);
        ParkingLot northParkingLot = new ParkingLot(1);

        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        parkingLots.add(southParkingLot);
        parkingLots.add(northParkingLot);
    }
    @Test
    public void testManagerParkingLotNum() {
        manager.manage(parkingLots);

        assertEquals(4, manager.getLots());
    }

    @Test
    public void testManagerParkCarWhenParkingLotAvailable() throws Exception {
        Manager manager = new Manager();
        manager.manage(parkingLots);
        Car benz = new Car();

        assertEquals(true, manager.park(benz));
    }

    @Test
    public void testManagerParkCarWhenNoParkingLotAvailable() throws Exception {
        Manager manager = new Manager();
        parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot(1);
        ParkingLot westParkingLot = new ParkingLot(1);
        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        Car benz = new Car();
        Car audi = new Car();
        Car ford = new Car();

        manager.manage(parkingLots);
        benz.park(eastParkingLot);
        audi.park(westParkingLot);

        assertEquals(false, manager.park(ford));
    }
}
