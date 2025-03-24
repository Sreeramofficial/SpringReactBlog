package com.sreeram.blog.Blog.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException e) {
        // Create an ErrorDto with the custom message and return with 404 status
        ErrorDto errorDto =
                new ErrorDto(320, "User not found",
                        "sreeram");

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnderEighteenNotAllowed.class)
    public ResponseEntity<?> ageExceptionHandler(UnderEighteenNotAllowed e) {
        // Create an ErrorDto with the custom message and return with 404 status
        ErrorDto errorDto =
                new ErrorDto(203, "Under 18 not allowed",
                        "Kuttettan");

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IsEmailIDNull.class)
    public ResponseEntity<?> ageExceptionHandler(IsEmailIDNull e) {
        // Create an ErrorDto with the custom message and return with 404 status
        ErrorDto errorDto =
                new ErrorDto(203, "Not Found ",
                        "Kuttettan");

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


}
