package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Speakers;
import com.pluralsight.conferencedemo.repositories.SpeakersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakersRepository speakersRepository; //gives me access to data

    @GetMapping
    public List<Speakers> list(){
        return speakersRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speakers get(@PathVariable Long id){
        return speakersRepository.getOne(id);
    }

    //third portion not saved in demo for other file but keeping for reference
}
