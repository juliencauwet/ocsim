package com.ocsin.test.services;

import com.ocsin.test.model.RoomObject;

import java.util.List;

public interface IRoomObjectService {

    RoomObject getRoomById(int roomId);
    RoomObject saveRoom(RoomObject room);
    RoomObject getRoomByName(String roomName);
    List<RoomObject> findRoomsWithAtLeastOneEvent();
    List<RoomObject> searchRoomsContainingCharacters(String key);
}
