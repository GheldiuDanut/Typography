package org.example.service;

import org.example.DAO.AuthorDAOImpl;
import org.example.DAO.BookDAOImpl;
import org.example.DAO.DAO;
import org.example.entity.Author;
import org.example.entity.Book;

import java.util.List;
import java.util.Optional;

public class AuthorService implements Service<Author> {

  private final DAO<Author> authorDAO;

  private final DAO<Book> bookDAO;

  public AuthorService() {
    this.authorDAO = new AuthorDAOImpl();
    this.bookDAO = new BookDAOImpl();
  }

  @Override
  public List<Author> getAll() {
    return authorDAO.getAll();
  }

  @Override
  public Optional<Author> getById(Integer id) {
    return authorDAO.getById(id);
  }

  @Override
  public void persist(Author author) {
    authorDAO.persist(author);
  }

  @Override
  public void delete(Author author) {
    authorDAO.delete(author);
  }

  @Override
  public void update(Author author, String... args) {
    authorDAO.update(author, args);
  }

}
