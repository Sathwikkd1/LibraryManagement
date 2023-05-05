package com.kdu.JavaAssessment2.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> objectNotfoundException(ObjectNotFoundException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("Oops users not present", HttpStatus.OK);
    }
    @ExceptionHandler(InvalidObjectInput.class)
    public ResponseEntity<String> invalidInput(InvalidObjectInput exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("Invalid object passed",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runTimeError(RuntimeException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("No Such data present",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<String> uniqueConstarintException(UniqueConstraintException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("The username given is allready exist please try another username1",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> uniqueConstarintException(DataIntegrityViolationException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("The username given is allready exist please try another username",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> uniqueConstarintException(Exception exception){
        log.error(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>("Exception occured",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> uniqueConstarintException(ConstraintViolationException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("The username given is allready exist please try another username",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(GeoCodingApiException.class)
    public ResponseEntity<String> geoCodingException(GeoCodingApiException exception){
        log.error(exception.getMessage());
        return  new ResponseEntity<>("Oops there is some issue please try again",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> expiredJwtToken(ExpiredJwtException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("Login time expired pleae login again",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotUserOftheHouseException.class)
    public ResponseEntity<String> notUserOfTheHouse(NotUserOftheHouseException exception){
        log.error(exception.getMessage());
        return new ResponseEntity<>("You are not the user of this house",HttpStatus.BAD_REQUEST);
    }
}

