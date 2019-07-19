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
    @Override
    public RoomObject getRoomById(int roomId){
        logger.info("##### getRoomObjectById method #####");
        return roomRepository.findById(roomId);
    }

    /**
     * récupère l'objet en base de données correspondant au nom de salle entré en paramètre
     * @param roomName
     * @return l'objet RoomObject correspondant au paramètre roomName
     */
    @Override
    public RoomObject getRoomByName(String roomName){
        logger.info("##### getRoomObjectByName method #####");
        return roomRepository.findByName(roomName);
    }

    /**
     * persiste un objet RoomObject entré en paramètre
     * @param room
     */
    @Override
    public void saveRoom(RoomObject room){
        logger.info("##### saveRoomObject method #####");
        roomRepository.save(room);
    }


    /**
     * @return l'ensemble des salles ayant chacune au moins un évènement
     */
    @Override
    public List<RoomObject> findRoomsWithAtLeastOneEvent() {
        logger.info("##### findRoomsWithAtLeastOneEvent method #####");
        return roomRepository.findDistinctRoomsByEventsIsNotNull();
    }
}
