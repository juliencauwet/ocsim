package com.ocsim.test.services.impl;

import com.ocsim.test.TestApplication;
import com.ocsim.test.model.Event;
import com.ocsim.test.model.RoomObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplication.class
)
@TestPropertySource(locations = "classpath:application-test.properties")
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Autowired
    private RoomObjectService roomService;

    private RoomObject room;
    private RoomObject room2;
    private Event event1;
    private Event event2;
    private Event event3;


    /**
     * initialisation grâce à la création d'objets et persistence en base de données test
     */
    @Before
    public void init(){

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2019, 2, 3);
        calendar2.set(2019, 3, 1);
        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();

        room = roomService.saveRoom(new RoomObject("salle_1"));
        room2 = roomService.saveRoom(new RoomObject( "salle_2"));

        event1 = new Event(date1, "motion:on", "salle_1");
        event1.setRoomObject(room);
        event2 = new Event(date2, "motion:off", "salle_2");
        event2.setRoomObject(room2);
        event3 = new Event(new Date(), "motion:on", "salle_1");
        event3.setRoomObject(room);

        eventService.saveEvent(event1);
        eventService.saveEvent(event2);
        eventService.saveEvent(event3);

    }

    /**
     * teste qu'un évènement a bien été enregistré en récupérant son id. Si l'id est positif c'est qu'il a été généré automatiquement comme prévu
     */
    @Test
    public void saveEvent() {
        Event regEvent = eventService.saveEvent(new Event (new Date(), "test", "salle_1"));
        Assert.assertTrue(regEvent.getId() > 0);
    }

    /**
     * vérifie que l'évènement retourné par la méthode pour l'objet room (qui a 2 évènements)  est le plus récent (celui créé maintenant)
     */
    @Test
    public void getRoomsLastEvent() {
        Event event = eventService.getRoomsLastEvent(room.getId());
        Assert.assertEquals(event3.getTime(), event.getTime());
    }
}
