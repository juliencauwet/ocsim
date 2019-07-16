package com.ocsim.test.services;

import com.ocsim.test.model.RoomObject;

import java.util.List;

public interface IRoomObjectService {

    RoomObject getRoomObjectById(int roomId);
    void saveRoomObject(RoomObject room);
    RoomObject getRoomObjectByName(String roomName);
    List<RoomObject> findRoomObjectsWithAtLeastOneEvent();
}
