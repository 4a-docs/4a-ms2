package com.example.agenda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody

public class AgendaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AgendaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(AgendaNotFoundException ex){
        return ex.getMessage();
    }
}