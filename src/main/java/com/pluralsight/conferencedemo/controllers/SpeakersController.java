package com.pluralsight.conferencedemo.controllers;



import com.pluralsight.conferencedemo.models.Speakers;
import com.pluralsight.conferencedemo.repositories.SpeakersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//CREATE METHOD
    @PostMapping
    public Speakers create(@RequestBody final Speakers speakers){
        return  speakersRepository.saveAndFlush(speakers);
    }

    //DELETE METHOD
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakersRepository.deleteById(id);
    }

    //UPDATE METHOD
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers speakers){
        Speakers existingSpeakers = speakersRepository.getOne(id);
        BeanUtils.copyProperties(speakers, existingSpeakers, "speaker_id");
        return speakersRepository.saveAndFlush(existingSpeakers);
    }
}
