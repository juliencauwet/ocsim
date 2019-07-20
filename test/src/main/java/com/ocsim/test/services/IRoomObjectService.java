package com.ocsim.test.services;

import com.ocsim.test.model.RoomObject;

import java.util.List;

public interface IRoomObjectService {

    RoomObject getRoomById(int roomId);
    RoomObject saveRoom(RoomObject room);
    RoomObject getRoomByName(String roomName);
    List<RoomObject> findRoomsWithAtLeastOneEvent();
}
