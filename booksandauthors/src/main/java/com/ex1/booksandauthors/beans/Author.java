package com.ex1.booksandauthors.beans;


import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "authors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @Singular
    private Set<Book> books = new HashSet<>();

//    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
//    @Singular
//    private List<Book> books = new ArrayList<>();
}
