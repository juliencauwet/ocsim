package com.ocsin.test;

import com.ocsin.test.api.EventApi;
import com.ocsin.test.dao.EventRepository;
import com.ocsin.test.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventApi eventApi;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Calendar calendar3 = Calendar.getInstance();

		calendar1.set(2019, 3, 23);
		calendar2.set(2019, 5, 12);
		calendar3.set(2019, 8, 28);

		Date date1 = calendar1.getTime();
		Date date2 = calendar2.getTime();
		Date date3 = calendar3.getTime();

		Event event = new Event(date1, "motion:on", "salle_1");
		Event event2 = new Event(date2, "motion:off", "salle_1");
		Event event3 = new Event(date3, "motion:on", "salle_2");

		eventApi.receiveEvent(event);
		eventApi.receiveEvent(event2);
		eventApi.receiveEvent(event3);
	}
}
