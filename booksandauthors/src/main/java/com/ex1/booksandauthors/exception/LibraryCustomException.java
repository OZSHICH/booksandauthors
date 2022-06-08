package com.ex1.booksandauthors.exception;

public class LibraryCustomException extends Exception {

    public LibraryCustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
