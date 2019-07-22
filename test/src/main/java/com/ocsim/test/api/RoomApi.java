package com.ocsim.test.api;

import com.ocsim.test.model.RoomObject;
import com.ocsim.test.services.impl.RoomObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * point d'entrée de l'API concernant les salles
 */
@RequestMapping("/rooms")
@RestController
@CrossOrigin(value = "*")
public class RoomApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomObjectService roomService;

    @GetMapping("/")
    public List<RoomObject> fetchListOfRoomsWithAtLeastOneEvent(){
        logger.info("fetchListOfRoomsWithAtLeastOneEvent method");
        return roomService.findRoomsWithAtLeastOneEvent();
    }

    @GetMapping("/{keyword}")
    public List<RoomObject> searcRoomByExpression(@PathVariable ("keyword") String keyword){
        logger.info("searcRoomByExpression method");
        logger.info("expression recherchée:" + keyword);
        return roomService.searchRoomsContainingCharacters(keyword);
    }
}
