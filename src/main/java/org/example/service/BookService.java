package org.example.service;

import jakarta.transaction.Transactional;
import org.example.DAO.DAO;
import org.example.entity.Author;
import org.example.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookService implements Service<Book> {

  private final DAO<Book> bookDAO;
  private final DAO<Author> authorDAO;

  public BookService(DAO<Book> bookDAO, DAO<Author> authorDAO) {
    this.bookDAO = bookDAO;
    this.authorDAO = authorDAO;
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
  public void persist(Book book) {
    for (Author author : book.getAuthors()) {
      Optional<Author> optionalAuthor = authorDAO.getByName(author.getAuthorName());
      optionalAuthor.ifPresent(value -> author.setId(value.getId()));
    }
    bookDAO.persist(book);

  }

  @Override
  public void delete(Book book) {
    bookDAO.delete(book);
  }

  @Override
  public void update(Book book, String... args) {
    bookDAO.update(book, args);
  }

}

