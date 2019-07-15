package com.ocsim.test.services;

import com.ocsim.test.model.Room;

import java.util.List;

public interface IRoomService {

    Room getRoomById(int roomId);
    void saveRoom(Room room);
    Room getRoomByName(String roomName);
    List<Room> findRoomsWithAtLeastOneEvent();
}
