package com.ocsim.test.services;

import com.ocsim.test.model.Event;

public interface IEventService {

    Event saveEvent(Event event);
    Event getRoomsLastEvent(int roomId);
}
