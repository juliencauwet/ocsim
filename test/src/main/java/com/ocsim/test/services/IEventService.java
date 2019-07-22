package com.ocsim.test.services;

import com.ocsim.test.model.Event;

import java.util.List;

public interface IEventService {

    Event saveEvent(Event event);
    Event getRoomsLastEvent(int roomId);
    List<Event> getListOfEventsperRoom(int roomId);
}
