package org;

/**
 * Created by jukzhang on 10/20/16.
 */
public interface Action {
    public ParkingLot park() throws Exception;
    public ParkingLot leave() throws Exception;
}
