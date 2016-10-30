import org.Car;
import org.Manager;
import org.ParkingLot;
import org.SmartManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class SmartManagerTest {
    public SmartManager smartManager;
    public ArrayList<ParkingLot> parkingLots;
    @Before
    public void setUp() {
        smartManager = new SmartManager();
        parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot(2);
        ParkingLot westParkingLot = new ParkingLot(3);
        ParkingLot southParkingLot = new ParkingLot(5);
        ParkingLot northParkingLot = new ParkingLot(4);

        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        parkingLots.add(southParkingLot);
        parkingLots.add(northParkingLot);
    }

    @Test
    public void testSmartManagerParkCarWhenParkingLotAvailable() throws Exception {
        Car benz = new Car();
        smartManager.park(benz);

        assertEquals(1, parkingLots.get(2).checkParkStatus());
    }
}
