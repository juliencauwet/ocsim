package com.ocsim.test.services.impl;

import com.ocsim.test.dao.RoomRepository;
import com.ocsim.test.model.RoomObject;
import com.ocsim.test.services.IRoomObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomObjectService implements IRoomObjectService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomRepository roomRepository;

    /**
     * récupère l'objet en base de données correspondant à l'id entré en paramètre
     * @param roomId
     * @return l'objet RoomObject correspondant au paramètre roomId
     */
    public RoomObject getRoomObjectById(int roomId){
        logger.info("##### getRoomObjectById method #####");
        return roomRepository.getOne(roomId);
    }

    /**
     * récupère l'objet en base de données correspondant au nom de salle entré en paramètre
     * @param roomName
     * @return l'objet RoomObject correspondant au paramètre roomName
     */
    public RoomObject getRoomObjectByName(String roomName){
        logger.info("##### getRoomObjectByName method #####");
        return roomRepository.findByName(roomName);
    }

    /**
     * persiste un objet RoomObject entré en paramètre
     * @param room
     */
    public void saveRoomObject(RoomObject room){
        logger.info("##### saveRoomObject method #####");
        roomRepository.save(room);
    }


    @Override
    public List<RoomObject> findRoomObjectsWithAtLeastOneEvent() {
        return roomRepository.findRoomsByEventsIsNotNull();
    }
}
