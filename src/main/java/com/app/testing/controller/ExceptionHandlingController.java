package com.app.testing.controller;

import com.app.testing.exception.impl.ValidationExceptions;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
    private final static Logger logger = Logger.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(ValidationExceptions.UserAlreadyExists.class)
    public ResponseEntity<String> userAlreadyExists() {
        logger.info("User already exists exception handled.");
        return new ResponseEntity<>("User already exists!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationExceptions.NoSuchUser.class)
    public ResponseEntity<String> noSuchUser() {
        logger.info("No such user exception handled.");
        return new ResponseEntity<>("This user doesn't exists!",HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntime(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
//        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}