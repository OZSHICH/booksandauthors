package com.ex1.booksandauthors.repository;

import com.ex1.booksandauthors.beans.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByYearBetween(int startYear, int endYear);

}
