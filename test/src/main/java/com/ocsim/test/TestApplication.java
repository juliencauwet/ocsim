package com.ocsim.test;

import com.ocsim.test.model.Room;
import com.ocsim.test.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private RoomService roomService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Room room = new Room();
		room.setName("salle_1");
		roomService.saveRoom(room);
	}
}
