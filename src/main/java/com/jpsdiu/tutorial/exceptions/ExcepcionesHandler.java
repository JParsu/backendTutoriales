package com.jpsdiu.tutorial.exceptions;

import com.jpsdiu.tutorial.exceptions.exception.TitleIsEmptyException;
import com.jpsdiu.tutorial.exceptions.exception.TutorialNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionesHandler {

    @ExceptionHandler(value = TitleIsEmptyException.class)
    public ResponseEntity<Object> titleisEmpty(TitleIsEmptyException titleIsEmptyException){
        return new ResponseEntity<>("El título esta vacio", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = TutorialNotFoundException.class)
    public ResponseEntity<Object> tutorialNotFound(TutorialNotFoundException tutorialNotFoundException){
        return new ResponseEntity<>("No se ha encontrado el tutorial",HttpStatus.NOT_FOUND);
    }


}
