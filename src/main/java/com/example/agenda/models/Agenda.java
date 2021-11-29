package com.example.agenda.models;

import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {

    @Id
    private String id;
    private String doctor;
    private LocalTime start_hour;
    private LocalDate start_date;

    public Agenda(String id, String doctor, LocalTime start_hour, LocalDate start_date) {
        this.id = id;
        this.doctor = doctor;
        this.start_hour = start_hour;
//        this.end_hour = end_hour;
        this.start_date = start_date;
//        this.end_date = end_date;
    }

    public String getId() {
        return id;
    }

    public String getDoctor() {
        return doctor;
    }

    public LocalTime getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(LocalTime start_hour) {
        this.start_hour = start_hour;
    }

//    public LocalTime getEnd_hour() {
//        return end_hour;
//    }
//
//    public void setEnd_hour(LocalTime end_hour) {
//        this.end_hour = end_hour;
//    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

//    public LocalDate getEnd_date() {
//        return end_date;
//    }
//
//    public void setEnd_date(LocalDate end_date) {
//        this.end_date = end_date;
//    }
}
