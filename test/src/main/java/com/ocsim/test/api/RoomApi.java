package com.ocsim.test.api;

import com.ocsim.test.services.impl.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * point d'entrée de l'API concernant les salles
 */
@RequestMapping("/rooms")
@RestController
public class RoomApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomService roomService;
}
