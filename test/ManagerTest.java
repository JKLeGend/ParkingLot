import org.Manager;
import org.ParkingLot;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ManagerTest {
    @Test
    public void testManagerParkingLotNum() {
        Manager manager = new Manager();
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        ParkingLot eastParkingLot = new ParkingLot(5);
        ParkingLot westParkingLot = new ParkingLot(4);
        ParkingLot southParkingLot = new ParkingLot(3);
        ParkingLot northParkingLot = new ParkingLot(2);

        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        parkingLots.add(southParkingLot);
        parkingLots.add(northParkingLot);

        manager.manage(parkingLots);

        assertEquals(4, manager.getLots());
    }
}
