package com.ocsim.test.api;

import com.ocsim.test.model.Event;
import com.ocsim.test.model.Room;
import com.ocsim.test.services.EventService;
import com.ocsim.test.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * point d'entrée de l'API
 */
@RequestMapping("/events")
@RestController
public class EventApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomService roomService;

    @Autowired
    private EventService eventService;

    /**
     * réception d'un évènement en provenance des salles, recherche de la salle en fonction de son nom, changement du statut de la salle en fonction de l'évènement, enregistrement de l'évènement
     * @param event
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void receiveEvent(@RequestBody Event event){

        logger.info("##### receiveEvent method #####");
        //récupération de la salle dont le nom correspond à celui de l'évènement
        Room room = roomService.getRoomByName(event.getRoom());

        room.setAvailability(event.getEvent().equals("motion:on")? true : false);

        roomService.saveRoom(room);
        event.setRoomObject(room);
        eventService.saveEvent(event);
    }

}
