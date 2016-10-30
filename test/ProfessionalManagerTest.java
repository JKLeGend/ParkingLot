import org.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManagerTest {
    public ProfessionalManager pm;
    public ArrayList<Manager> managers;
    public ArrayList<ParkingLot> parkingLots;

    @Before
    public void setUp() {
        pm = new ProfessionalManager();
        managers = new ArrayList();
        parkingLots = new ArrayList();
        Manager manager = new Manager();
        SmartManager smartManager = new SmartManager();
        ParkingLot eastParkingLot = new ParkingLot(4);
        ParkingLot westParkingLot = new ParkingLot(5);
        managers.add(manager);
        managers.add(smartManager);
        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
    }
    @Test
    public void testPMMangement() {
        pm.manage(managers, parkingLots);

        assertEquals(2, pm.getManagers().size());
        assertEquals(2, pm.getParkingLots().size());
    }

    @Test
    public void testPMParkCar() throws Exception {
        pm.manage(managers, parkingLots);
        Car benz = new Car();

        pm.park(benz);

        assertEquals(1, pm.getParkingLots().get(1).checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testPMParkCarByManagerNoAuthority() throws Exception {
        pm.manage(managers, parkingLots);
        Car benz = new Car();
        Manager manager = new Manager();
        manager.manage(parkingLots);

        pm.park(manager, benz);
    }

    @Test
    public void testPMParkCarByManager() throws Exception {
        pm.manage(managers, parkingLots);
        Car benz = new Car();
        Manager manager = managers.get(0);
        manager.manage(parkingLots);

        pm.park(manager, benz);

        assertEquals(1, pm.getParkingLots().get(0).checkParkStatus());
    }

    @Test
    public void testPMParkCarBySmartManager() throws Exception {
        pm.manage(managers, parkingLots);
        Car benz = new Car();
        SmartManager smartManager = (SmartManager) managers.get(1);
        smartManager.manage(parkingLots);

        pm.park(smartManager, benz);

        assertEquals(1, pm.getParkingLots().get(1).checkParkStatus());
    }
}
