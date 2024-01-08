package org.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Book {
    public Book(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(unique = true, name = "book_name")
    private String name;

    @ManyToMany(mappedBy = "books")

    private List<Author>authors = new ArrayList<>();

    public void addAuthor(final Author author){
        this.authors.add(author);
    }
}
