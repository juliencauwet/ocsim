package com.ocsim.test.dao;

import com.ocsim.test.model.RoomObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <RoomObject, Integer> {

    RoomObject findById(int id);
    RoomObject findByName(String name);
    List<RoomObject> findDistinctRoomsByEventsIsNotNull();


}
