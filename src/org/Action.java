package org;

/**
 * Created by jukzhang on 10/20/16.
 */
public interface Action {
    ParkingLot park(ParkingLot parkingLot) throws Exception;
    ParkingLot leave(ParkingLot parkingLot) throws Exception;
}
