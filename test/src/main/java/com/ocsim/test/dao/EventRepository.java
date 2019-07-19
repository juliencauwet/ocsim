package com.ocsim.test.dao;

import com.ocsim.test.model.Event;
import com.ocsim.test.model.RoomObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findTopByRoomObjectOrderByTimeDesc(RoomObject room);
}
