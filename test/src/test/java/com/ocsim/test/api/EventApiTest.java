package com.ocsim.test.api;

import com.ocsim.test.model.Event;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventApiTest extends AbstractTestClass {

    @Test
    public void receiveEvent() throws Exception{
        String uri = "/events/";
        Event event = new Event();
        event.setEvent("motion:on");
        event.setRoom("salle_1");
        event.setTime(new Date());

        String inputJson = super.mapToJson(event);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
