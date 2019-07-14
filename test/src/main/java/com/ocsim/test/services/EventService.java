package com.ocsim.test.services;

import com.ocsim.test.dto.EventRepository;
import com.ocsim.test.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventRepository eventRepository;

    /**
     * enregistre un évènement en base de donnée
     * @param event
     */
    public void saveEvent(Event event){
        eventRepository.save(event);
    }

}
