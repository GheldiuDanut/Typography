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

        Service<Author>authorService = new AuthorService();
        Service<Book>bookService = new BookService(bookDAO, authorDAO);

        Author author = new Author();
        author.setAuthorName("Danut");
        author.setAge(25);

        author.addBook(new Book("Noua carte"));


        authorService.persist(author);

        Book book = new Book();
        book.setName("xyz");
        book.setAuthors(new ArrayList<>(List.of(new Author("Ionut"),new Author("Danut"), new Author("Adrian"))));
        bookService.persist(book);




        }
    }
