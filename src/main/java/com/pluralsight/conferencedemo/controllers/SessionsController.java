package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
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
//adding a create method for when passed into controller through endpoint


    //CREATE METHOD
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) without the default 200 status will be sent but in real life we want this line of code
    public Session create(@RequestBody final Session session){ //taking in attributes and creating session object save and flushing it flushing is what actially saves the data to the database
        return sessionRepository.saveAndFlush(session);
    }

    //DELETE METHOD

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) //delete and create are HTTP methods
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting
        //this method will only delte sessions without children records ->Further STudy find how to delete sessions with children recors
        sessionRepository.deleteById(id);
    }
//UPDATE Implementation

    @RequestMapping(value = "{id}", method = RequestMethod.PUT) //can use PUT or PATCH method - Patch allows for portional updates
    public Session update(@PathVariable Long id, @RequestBody Session session){
        //we want to add validations that all attributes are passed in else return 400 bad payload
        Session existingSession =sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }



}
