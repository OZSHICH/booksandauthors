package com.ex1.booksandauthors.clrVCommandLineRunner;

import com.ex1.booksandauthors.beans.*;
import com.ex1.booksandauthors.exception.*;
import com.ex1.booksandauthors.repository.*;
import com.ex1.booksandauthors.services.*;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;


@Component
@RequiredArgsConstructor
public class testAll implements CommandLineRunner {

    private final RestTemplate restTemplate;
//
//    private final AuthorRepository authorRepository;
//
//    private final BookRepository bookRepository;
//
//    private final LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {




        Book b1 = Book
                .builder()
                .name("Harry Potter and the Philosopher's Stone")
                .year(1997)
                .build();

        Book b2 = Book
                .builder()
                .name("Harry Potter and the Chamber of Secrets")
                .year(1998)
                .build();

        Book b3 = Book
                .builder()
                .name("Harry Potter and the Prisoner of Azkaban")
                .year(1999)
                .build();

        Book b4 = Book
                .builder()
                .name("Harry Potter and the Goblet of Fire")
                .year(2000)
                .build();

        Book b5 = Book
                .builder()
                .name("Harry Potter and the Order of the Phoenix\n")
                .year(2003)
                .build();

        Book b6 = Book
                .builder()
                .name("Harry Potter and the Half-Blood Prince")
                .year(2005)
                .build();

        Book b7 = Book
                .builder()
                .name("Harry Potter and the Deathly Hallows")
                .year(2007)
                .build();

        Book b8 = Book
                .builder()
                .name("The Godfather")
                .year(1969)
                .build();

        Book b9 = Book
                .builder()
                .name("The Godfather Part 2")
                .year(1974)
                .build();

        Book b10 = Book
                .builder()
                .name("The Godfather Part 3")
                .year(1990)
                .build();


        Author a1 = Author
                .builder()
                .name("J.K. Rowling")
                .book(b1)
                .book(b2)
                .book(b3)
                .book(b4)
                .book(b5)
                .book(b6)
                .book(b7)
                .build();

        Author a2 = Author
                .builder()
                .name("Mario Puzo")
                .book(b8)
                .book(b9)
                .book(b10)
                .build();

        Author a3 = Author
                .builder()
                .name("adasda sadasds")
                .book(b8)
                .book(b9)
                .book(b10)
                .build();


        ResponseEntity<String> rest1 = restTemplate.postForEntity("http://localhost:8080/api/booksandauthors/authors", a1, String.class);
        System.out.println("*********addAuthor********");
        System.out.println((rest1.getStatusCode().is2xxSuccessful()) ? "Good " : "Bad");

        System.out.println("*********addAuthor********");
        ResponseEntity<String> rest2 = restTemplate.postForEntity("http://localhost:8080/api/booksandauthors/authors", a2, String.class);
        System.out.println((rest2.getStatusCode().is2xxSuccessful()) ? "Good " : "Bad");
//
//        System.out.println("*********addAuthor********");
//        ResponseEntity<String> rest10 = restTemplate.postForEntity("http://localhost:8080/api/booksandauthors/authors", a3, String.class);
//        System.out.println((rest10.getStatusCode().is2xxSuccessful()) ? "Good " : "Bad");

//        System.out.println("*********deleteAuthor********");
//        restTemplate.delete("http://localhost:8080/api/booksandauthors/authors/1");

        System.out.println("*********getAllBooks********");
        ResponseEntity<Book[]> rest3 = restTemplate.getForEntity("http://localhost:8080/api/booksandauthors/books", Book[].class);
        List<Book> books = Arrays.asList(rest3.getBody());
        System.out.println(books);

        System.out.println("*********getOneAuthorById********");
        Author rest4 = restTemplate.getForObject("http://localhost:8080/api/booksandauthors/authors/2", Author.class);
        System.out.println(rest4);

        System.out.println("*********getAllBooksBtwYears********");
        ResponseEntity<Book[]> rest5 = restTemplate.getForEntity("http://localhost:8080/api/booksandauthors/booksbtw/1985-2005", Book[].class);
        List<Book> booksBtwYears = Arrays.asList(rest5.getBody());
        System.out.println(booksBtwYears);

        System.out.println("*********getAllBooksYearsAvg********");
        String rest6 = restTemplate.getForObject("http://localhost:8080/api/booksandauthors/booksavg", String.class);
        System.out.println(rest6);
//
//        System.out.println("*********getAllBooksYearAvgById********");
//        String rest7 = restTemplate.getForObject("http://localhost:8080/api/booksandauthors/booksavgbyid/2", String.class);
//        System.out.println(rest7);

        Author updateAuthor1 = Author
                .builder()
                .name("Tom")
                .build();
        updateAuthor1.setId(Objects.requireNonNull(restTemplate.getForEntity("http://localhost:8080/api/booksandauthors/authors/1", Author.class).getBody()).getId());
        updateAuthor1.setBooks(Objects.requireNonNull(restTemplate.getForEntity("http://localhost:8080/api/booksandauthors/authors/1", Author.class).getBody()).getBooks());
        HttpEntity<Author> requestUpdate = new HttpEntity<>(updateAuthor1);
        restTemplate.exchange("http://localhost:8080/api/booksandauthors/authors/1", HttpMethod.PUT, requestUpdate, Author.class);
//
//
//        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10));
//        authorRepository.saveAll(Arrays.asList(a1,a2));
//        System.out.println();
//
//        System.out.println("*********getAllBooksYearsAvg********");
//        System.out.println(libraryService.getAllBooksYearsAvg());
//
//        System.out.println("*********getAllBooksBtwYears********");
//        System.out.println(libraryService.getAllBooksBtwYears(1985,2000));
//
//        System.out.println("*********getAllBooksYearAvgById********");
//        System.out.println(libraryService.getAllBooksYearAvgById(1));
//
//        System.out.println("*********deleteAuthor********");
//
//        libraryService.deleteAuthor(1);
//        try {
//            libraryService.deleteAuthor(1);
//        } catch (LibraryCustomException e){
//            System.out.println(e.getMessage());
//        }

    }
}
