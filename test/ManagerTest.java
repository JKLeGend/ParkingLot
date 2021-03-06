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
        manager = new Manager("Ma Huateng");
        parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot("east", 1);
        ParkingLot westParkingLot = new ParkingLot("west", 1);
        ParkingLot southParkingLot = new ParkingLot("south", 1);
        ParkingLot northParkingLot = new ParkingLot("north", 1);

        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        parkingLots.add(southParkingLot);
        parkingLots.add(northParkingLot);
    }

    @Test
    public void testManagerParkingLotNum() {
        manager.manage(parkingLots);

        assertEquals(4, manager.getLots().size());
    }

    @Test
    public void testManagerParkCarWhenParkingLotAvailable() throws Exception {
        manager.manage(parkingLots);
        Car benz = new Car();

        assertEquals(true, manager.park(benz));
        assertEquals(1, manager.getLots().get(0).checkParkStatus());
        assertEquals(0, manager.getLots().get(1).checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testManagerParkCarWhenNoParkingLotsAvailable() throws Exception {
        parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot("east", 1);
        ParkingLot westParkingLot = new ParkingLot("west", 1);
        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        Car benz = new Car();
        Car audi = new Car();
        Car ford = new Car();

        manager.manage(parkingLots);
        benz.park(eastParkingLot);
        audi.park(westParkingLot);

        manager.park(ford);
    }

    @Test
    public void testManagerFetchCarWhenFindCarInParkingLots() throws Exception {
        manager.manage(parkingLots);
        Car benz = new Car();
        benz.park(parkingLots.get(0));

        assertEquals(true, manager.fetch(benz));
    }

    @Test(expected = Exception.class)
    public void testManagerFetchCarWhenNotFindCarInParkingLots() throws Exception {
        manager.manage(parkingLots);
        Car benz = new Car();
        Car audi = new Car();
        benz.park(parkingLots.get(0));

        manager.fetch(audi);
    }
}
