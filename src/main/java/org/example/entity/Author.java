package org.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Danut")
@Setter
@Getter
@ToString
@NoArgsConstructor


public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String authorName;

    private Integer age;

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns =  @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book>books = new ArrayList<>();

    public void addBook(Book book){
        book.addAuthor(this);
        books.add(book);
    }
}
