import org.ParkingLot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void testParkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertEquals(10, parkingLot.getSlot());
    }
}