package com.ocsin.test.services;

import com.ocsin.test.model.Event;

import java.util.List;

public interface IEventService {

    Event saveEvent(Event event);
    Event getRoomsLastEvent(int roomId);
    List<Event> getListOfEventsperRoom(int roomId);
}
