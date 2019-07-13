package com.ocsim.test.services;

import com.ocsim.test.dto.RoomRepository;
import com.ocsim.test.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room getRoom(int roomId){
        return roomRepository.getOne(roomId);
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

}
