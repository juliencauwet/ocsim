package com.ocsim.test.dao;

import com.ocsim.test.model.Event;
import com.ocsim.test.model.RoomObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findTopByRoomObjectOrderByTimeDesc(RoomObject room);

    List<Event> findTop100ByRoomObjectOrderByTimeDesc(RoomObject room);
}
