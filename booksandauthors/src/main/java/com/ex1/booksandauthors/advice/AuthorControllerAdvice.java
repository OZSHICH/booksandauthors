package com.ex1.booksandauthors.advice;

import com.ex1.booksandauthors.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AuthorControllerAdvice {

    @ExceptionHandler(value = {LibraryCustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails errorHelper(Exception e) {
        return new ErrorDetails("An error occurred" ,e.getMessage());
    }
}
