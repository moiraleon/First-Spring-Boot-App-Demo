package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions") //specifying route path -> all requests to this url will be sent to this controller
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    //creating an endpoint that will return all the sessions when called

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")//adding id to url then pulls id off of url and injects it into the method
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) without the default 200 status will be sent but in real life we want this line of code
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }


}
