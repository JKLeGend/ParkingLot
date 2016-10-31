import org.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by jukzhang on 10/30/16.
 */
public class ProfessionalManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ProfessionalManager pm;
    public ArrayList<Manager> managers;
    public ArrayList<ParkingLot> parkingLots;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        pm = new ProfessionalManager("Li Jiacheng");
        managers = new ArrayList();
        parkingLots = new ArrayList();
        Manager manager = new Manager("Ma Yun");
        SmartManager smartManager = new SmartManager("Wang Jianlin");
        ParkingLot eastParkingLot = new ParkingLot("east", 4);
        ParkingLot westParkingLot = new ParkingLot("west", 5);
        managers.add(manager);
        managers.add(smartManager);
        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);

        pm.manage(managers, parkingLots);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testPMMangement() {
        assertEquals(2, pm.getManagers().size());
        assertEquals(2, pm.getParkingLots().size());
    }

    @Test
    public void testPMParkCar() throws Exception {
        Car benz = new Car();

        pm.park(benz);

        assertEquals(1, pm.getParkingLots().get(1).checkParkStatus());
    }

    @Test(expected = Exception.class)
    public void testPMParkCarByManagerNoAuthority() throws Exception {
        Car benz = new Car();
        Manager manager = new Manager("Liu Qiangdong");
        manager.manage(parkingLots);

        pm.park(manager, benz);
    }

    @Test
    public void testPMParkCarByManager() throws Exception {
        Car benz = new Car();
        Manager manager = managers.get(0);
        manager.manage(parkingLots);

        pm.park(manager, benz);

        assertEquals(1, pm.getParkingLots().get(0).checkParkStatus());
    }

    @Test
    public void testPMParkCarBySmartManager() throws Exception {
        Car benz = new Car();
        SmartManager smartManager = (SmartManager) managers.get(1);
        smartManager.manage(parkingLots);

        pm.park(smartManager, benz);

        assertEquals(1, pm.getParkingLots().get(1).checkParkStatus());
    }

    @Test
    public void testPMReport() throws Exception {
        managers = new ArrayList();
        parkingLots = new ArrayList();
        Manager manager1 = new Manager("Ma Yun");
        Manager manager2 = new Manager("Ma Huateng");
        SmartManager smartManager1 = new SmartManager("Wang Jianlin");
        SmartManager smartManager2 = new SmartManager("Li Jiacheng");
        ParkingLot eastParkingLot = new ParkingLot("east", 4);
        ParkingLot westParkingLot = new ParkingLot("west", 5);
        ParkingLot southParkingLot = new ParkingLot("south", 3);
        ParkingLot northParkingLot = new ParkingLot("north", 2);
        managers.add(manager1);
        managers.add(manager2);
        managers.add(smartManager1);
        managers.add(smartManager2);
        parkingLots = new ArrayList();
        parkingLots.add(eastParkingLot);
        parkingLots.add(westParkingLot);
        parkingLots.add(southParkingLot);
        parkingLots.add(northParkingLot);
        ArrayList<ParkingLot> parkingLots1 = new ArrayList<>(Arrays.asList(eastParkingLot, southParkingLot));
        ArrayList<ParkingLot> parkingLots2 = new ArrayList<>(Arrays.asList(westParkingLot, southParkingLot, northParkingLot));
        manager1.manage(parkingLots1);
        smartManager1.manage(parkingLots2);

        pm.manage(managers, parkingLots);
        Car benz = new Car();
        Car audi = new Car();
        pm.park(manager1, benz);
        pm.park(smartManager1, audi);

        pm.report();

        String result = "Li Jiacheng直属管理的停车场:\n" +
                        "east\n" +
                        "west\n" +
                        "south\n" +
                        "north\n" +
                        "管家及管理的停车场情况:\n" +
                        "Ma Yun\n" +
                        "east\n" +
                        "总共:4 已停1 剩余3\n" +
                        "south\n" +
                        "总共:3 已停0 剩余3\n" +
                        "Ma Huateng\n" +
                        "无\n" +
                        "Wang Jianlin\n" +
                        "west\n" +
                        "总共:5 已停1 剩余4\n" +
                        "south\n" +
                        "总共:3 已停0 剩余3\n" +
                        "north\n" +
                        "总共:2 已停0 剩余2\n" +
                        "Li Jiacheng\n" +
                        "无\n";

        assertEquals(result, outContent.toString());
    }
}
