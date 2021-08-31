package com.pluralsight.conferencedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;

@Entity(name ="speakers")
public class Speakers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Serial speaker_id;
    private Character first_name;
    private Character last_name;
    private Character title;
    private Character company;
    private Character speaker_bio;

    public Speakers(){

    }

    public Serial getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Serial speaker_id) {
        this.speaker_id = speaker_id;
    }

    public Character getFirst_name() {
        return first_name;
    }

    public void setFirst_name(Character first_name) {
        this.first_name = first_name;
    }

    public Character getLast_name() {
        return last_name;
    }

    public void setLast_name(Character last_name) {
        this.last_name = last_name;
    }

    public Character getTitle() {
        return title;
    }

    public void setTitle(Character title) {
        this.title = title;
    }

    public Character getCompany() {
        return company;
    }

    public void setCompany(Character company) {
        this.company = company;
    }

    public Character getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(Character speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
