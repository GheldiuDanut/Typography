package org.example;


import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.Service;

public class Main {
    public static void main(String[] args) {

        Service<Author>authorService = new AuthorService();
        Service<Book>bookService = new BookService();

        Author Danut = new Author();
        Danut.setAuthorName("Danut");
        Danut.setAge(25);

        Danut.addBook(new Book("Noua carte"));


        authorService.persist(Danut);




        }
    }
