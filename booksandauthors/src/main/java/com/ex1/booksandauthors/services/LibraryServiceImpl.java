package com.ex1.booksandauthors.services;

import com.ex1.booksandauthors.beans.*;
import com.ex1.booksandauthors.exception.*;
import com.ex1.booksandauthors.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void addAuthor(Author author) throws LibraryCustomException {
        if (authorRepository.existsById(author.getId())) {
            throw new LibraryCustomException(ErrorMessage.AUTHOR_ALREADY_EXIST);
        }
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) throws LibraryCustomException {
        if (!authorRepository.existsById(id)) {
            throw new LibraryCustomException(ErrorMessage.AUTHOR_NOT_EXIST);
        }
        authorRepository.deleteById(id);
        System.out.println("Author number " + id + " has been deleted");
    }

    @Override
    public void updateAuthor(int id, Author author) throws LibraryCustomException {
        if (!authorRepository.existsById(id)) {
            throw new LibraryCustomException(ErrorMessage.AUTHOR_NOT_EXIST);
        }
            authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getOneAuthor(int id) throws LibraryCustomException {
        //if (!authorRepository.existsById(id))
            //throw new LibraryCustomException(ErrorMessage.AUTHOR_NOT_EXIST);
        //return authorRepository.getById(id);
        return  authorRepository.findById(id).orElseThrow(()->new LibraryCustomException(ErrorMessage.AUTHOR_NOT_EXIST));
    }

    @Override
    public Book getOneBook(int id) throws LibraryCustomException {
        //if (!authorRepository.existsById(id))
            //throw new LibraryCustomException(ErrorMessage.AUTHOR_NOT_EXIST);
        //return authorRepository.getById(id);
        return  bookRepository.findById(id).orElseThrow(()->new LibraryCustomException(ErrorMessage.BOOK_NOT_EXIST));
    }

    @Override
    public List<Book> getAllBooksBtwYears(int startYear, int endYear) {
        return bookRepository.findAllByYearBetween(startYear, endYear);
    }

    @Override
    public double getAllBooksYearsAvg() {
        System.out.println("All books years avg is: ");
        return authorRepository.avg();
    }

    @Override
    public double getAllBooksYearAvgById(int id) {
        System.out.println("Author number " + id + " books years avg is: ");
        return authorRepository.avgById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
