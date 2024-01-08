package org.example;

import org.example.DAO.AuthorDAOImpl;
import org.example.DAO.BookDAOImpl;
import org.example.DAO.DAO;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    DAO<Book> bookDAO = new BookDAOImpl();
    DAO<Author> authorDAO = new AuthorDAOImpl();

    Service<Author> authorService = new AuthorService();
    Service<Book> bookService = new BookService(bookDAO, authorDAO);

    Author author = new Author();
    author.setAuthorName("Danut");
    author.setAge(25);

    author.addBook(new Book("Noua carte"));

    authorService.persist(author);

    Book book = new Book();
    book.setName("xyz");
    var ionut = new Author("Ionut", 21);
    ionut.addBook(book);
    var danut = new Author("Danut", 21);
    danut.addBook(book);
    var adrian = new Author("Adrian", 21);
    adrian.addBook(book);
    book.setAuthors(new ArrayList<>(List.of(ionut, danut, adrian)));
    bookService.persist(book);

    System.out.println(bookService.getById(1));

  }
}
