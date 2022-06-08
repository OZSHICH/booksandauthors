package com.ex1.booksandauthors.controller;

import com.ex1.booksandauthors.beans.*;
import com.ex1.booksandauthors.exception.*;
import com.ex1.booksandauthors.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/booksandauthors")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author) throws LibraryCustomException {
        libraryService.addAuthor(author);
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@PathVariable int id, @RequestBody Author author) throws LibraryCustomException {
        libraryService.updateAuthor(id, author);
    }


    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws LibraryCustomException {
        libraryService.deleteAuthor(id);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getOneAuthor(@PathVariable int id) throws LibraryCustomException {
        return libraryService.getOneAuthor(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/booksbtw/{startYear}-{endYear}")
    public List<Book> getAllBooksBtwYears(@PathVariable int startYear, @PathVariable int endYear) {
        return libraryService.getAllBooksBtwYears(startYear, endYear);
    }

    @GetMapping("/booksavg")
    public double getAllBooksYearsAvg() {
        return libraryService.getAllBooksYearsAvg();
    }

    @GetMapping("/booksavgbyid/{id}")
    public double getAllBooksAvgById(@PathVariable int id) {
        return libraryService.getAllBooksYearAvgById(id);
    }

    @GetMapping("/books/{id}")
    public Book getOneBook(@PathVariable int id) throws LibraryCustomException {
        return libraryService.getOneBook(id);
    }





}
