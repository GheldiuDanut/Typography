package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Author")
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

  @ManyToMany(fetch = FetchType.EAGER)
  @ToString.Exclude
  private List<Book> books = new ArrayList<>();

  public Author(String authorName, Integer age) {
    this.authorName = authorName;
    this.age = age;
  }

  public void addBook(Book book) {
    books.add(book);
  }
}
