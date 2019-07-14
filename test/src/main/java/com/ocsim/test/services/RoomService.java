package com.ocsim.test.services;

import com.ocsim.test.dto.RoomRepository;
import com.ocsim.test.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomRepository roomRepository;

    /**
     * récupère l'objet en base de données correspondant à l'id entré en paramètre
     * @param roomId
     * @return l'objet Room correspondant au paramètre roomId
     */
    public Room getRoomById(int roomId){
        logger.info("##### getRoomById method #####");
        return roomRepository.getOne(roomId);
    }

    /**
     * récupère l'objet en base de données correspondant au nom de salle entré en paramètre
     * @param roomName
     * @return l'objet Room correspondant au paramètre roomName
     */
    public Room getRoomByName(String roomName){
        logger.info("##### getRoomByName method #####");
        return roomRepository.findByName(roomName);
    }

    /**
     * persiste un objet Room entré en paramètre
     * @param room
     */
    public void saveRoom(Room room){
        logger.info("##### saveRoom method #####");
        roomRepository.save(room);
    }



}
