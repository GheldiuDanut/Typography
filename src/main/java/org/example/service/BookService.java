package org.example.service;

import org.example.DAO.BookDAOImpl;
import org.example.DAO.DAO;
import org.example.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookService implements Service<Book>{

    private final DAO<Book>bookDAO;

    public BookService() {
        this.bookDAO = new BookDAOImpl();
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public Optional<Book> getById(Integer id) {
        return bookDAO.getById(id);
    }

    @Override
    public Book persist(Book book) {
        return bookDAO.persist(book);
    }

    @Override
    public void delete(Book book) {
    bookDAO.delete(book);
    }

    @Override
    public void update(Book book, String... args) {
    bookDAO.update(book,args);
    }

    @Override
    public Optional<Book> exists(String name) {
        return Optional.empty();
    }

    @Override
    public void findByName(String name) {

    }
}
