package com.ocsim.test;

import com.ocsim.test.dao.EventRepository;
import com.ocsim.test.model.Event;
import com.ocsim.test.model.RoomObject;
import com.ocsim.test.services.impl.EventService;
import com.ocsim.test.services.impl.RoomObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private RoomObjectService roomService;

	@Autowired
	private EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RoomObject room = new RoomObject();
		room.setName("salle_1");
		roomService.saveRoom(room);

		RoomObject room2 = new RoomObject();
		room2.setName("salle_2");
		roomService.saveRoom(room2);

		Event event1 = new Event();
		event1.setRoomObject(room);
		event1.setEvent("motion:on");
		event1.setTime(new Date());
		eventService.saveEvent(event1);

	}
}
