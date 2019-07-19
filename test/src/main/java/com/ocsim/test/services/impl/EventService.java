package com.ocsim.test.services.impl;

import com.ocsim.test.dao.EventRepository;
import com.ocsim.test.model.Event;
import com.ocsim.test.model.RoomObject;
import com.ocsim.test.services.IEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventRepository eventRepository;

    @Autowired RoomObjectService roomObjectService;

    /**
     * enregistre un évènement en base de donnée
     * @param event
     */
    @Override
    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    /**
     *
     * @param roomId
     * @return
     */
    @Override
    public Event getRoomsLastEvent(int roomId) {
        logger.info("##### getRoomsLastEvent method #####");
        RoomObject room = roomObjectService.getRoomById(roomId);
        return eventRepository.findTopByRoomObjectOrderByTimeDesc(room);
    }

}
