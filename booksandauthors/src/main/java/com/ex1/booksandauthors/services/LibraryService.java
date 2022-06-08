package com.ex1.booksandauthors.services;

import com.ex1.booksandauthors.beans.*;
import com.ex1.booksandauthors.exception.*;

import java.util.*;

public interface LibraryService {

    void addAuthor(Author author) throws LibraryCustomException;

    void deleteAuthor(int id) throws LibraryCustomException;

    void updateAuthor(int id,Author author) throws LibraryCustomException;

    List<Author> getAllAuthors();

    Author getOneAuthor(int id) throws LibraryCustomException;

    Book getOneBook(int id) throws LibraryCustomException;

    List<Book> getAllBooksBtwYears(int startYear , int endYear);

    double getAllBooksYearsAvg();

    double getAllBooksYearAvgById(int id);

    List<Book> getAllBooks();



}
