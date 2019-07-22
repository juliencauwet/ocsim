package com.ocsin.test.dao;

import com.ocsin.test.model.RoomObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <RoomObject, Integer> {

    RoomObject findById(int id);
    RoomObject findByName(String name);
    List<RoomObject> findDistinctRoomsByEventsIsNotNull();
    List<RoomObject> findByNameContainingIgnoreCase(String name);


}
