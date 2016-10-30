import org.Manager;
import org.ParkingLot;
import org.ProfessionalManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManagerTest {
    @Test
    public void testPMMangement() {
        ProfessionalManager pm = new ProfessionalManager();
        ArrayList<Manager> managers = new ArrayList();
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        Manager manager = new Manager();
        ParkingLot parkingLot = new ParkingLot(5);
        managers.add(manager);
        parkingLots.add(parkingLot);

        pm.manage(managers, parkingLots);

        assertEquals(1, pm.getManagers());
        assertEquals(1, pm.getParkingLots());
    }
}
