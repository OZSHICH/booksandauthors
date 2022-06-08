package com.ex1.booksandauthors.exception;

import lombok.*;

@Getter
public enum ErrorMessage {
    AUTHOR_ALREADY_EXIST("Author already exists"),
    AUTHOR_NOT_EXIST("Author not exists"),
    BOOK_ALREADY_EXIST("Book already exists"),
    BOOK_NOT_EXIST("Book not exists");

    private String Message;

    ErrorMessage(String message) {
        Message = message;
    }
}

