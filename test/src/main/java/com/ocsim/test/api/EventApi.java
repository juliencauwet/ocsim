package com.ocsim.test.api;

import com.ocsim.test.model.Room;
import com.ocsim.test.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/events")
@RestController
public class EventApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RoomService roomService;

    /**
     * Récepetion d'un signal de la part d'une salle de réunion on ou off
     * @param status
     * @param roomId
     */
    @GetMapping("/{roomId}/{status}")
    public void updateRoomStatus(@PathVariable("status") String status, @PathVariable ("roomId") String roomId){
        logger.info("##### updateRoomStatus method #####");
        Room room = roomService.getRoom(Integer.parseInt(roomId));
        room.setAvailability(status == "on" ? true : false);
    }

}
