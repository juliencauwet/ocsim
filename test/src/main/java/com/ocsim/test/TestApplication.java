package com.ocsim.test;

import com.ocsim.test.model.RoomObject;
import com.ocsim.test.services.impl.RoomObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private RoomObjectService roomService;

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
	}
}
