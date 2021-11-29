package com.example.agenda.exceptions;

public class AgendaNotFoundException extends RuntimeException {
    public AgendaNotFoundException(String message){
        super(message);
    }
}
