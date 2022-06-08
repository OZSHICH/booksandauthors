package com.ex1.booksandauthors.repository;

import com.ex1.booksandauthors.beans.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT avg(year) from books", nativeQuery = true)
    double avg();

    @Query(value = "SELECT avg(year) from booksauthors.authors_books join booksauthors.books on authors_books.books_id = books.id where authors_books.author_id = ?;", nativeQuery = true)
    double avgById(int id);

}
