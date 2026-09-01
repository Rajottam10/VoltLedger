package io.voltledger.userservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    Logger log = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/users")
    public String getUsers(){
        log.info("info log");               // this log statement is accepted as UsersController logger level is INFO
        return "successfully fetched all users";
    }
}
