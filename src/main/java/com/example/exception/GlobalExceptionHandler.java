package com.example.exception;





import java.util.Date;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

 

@RestControllerAdvice
public class GlobalExceptionHandler {

 

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(UserNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

 

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException1(ProductNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException2(FeedbackNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException3(AdminNotFoundException exception, WebRequest request) {

 

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

 

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    

}
 
