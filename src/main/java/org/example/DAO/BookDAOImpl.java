package org.example.DAO;

import org.example.entity.Book;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements DAO<Book> {

    private final SessionFactory sessionFactory;

    private Session session;

    private Transaction transaction;


    public BookDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


    @Override
    public List<Book> getAll() {
        openSession();
        List<Book>books = this.session.createQuery("SELECT b FROM BOOKS b",Book.class).getResultList();
        closeSession();
        return books;
    }

    @Override
    public Optional<Book> getById(Integer id) {
        openSession();
        Optional<Book> book = Optional.ofNullable(session.get(Book.class,id));
        closeSession();
        return book;
    }

    @Override
    public Book persist(Book book) {
        openSessionAndTransaction();
        Book persistedBook = session.merge(book);
        closeSessionAndTransaction();
        return persistedBook;
    }

    @Override
    public void delete(Book book) {
    openSessionAndTransaction();
    this.session.remove(book);
    closeSessionAndTransaction();
    }

    @Override
    public void update(Book book, String... args) {

    }

    @Override
    public Optional<Book> getByName(String name) {
        return Optional.empty();
    }


    private void openSessionAndTransaction(){
        this.session = sessionFactory.openSession();
        this.transaction = session.beginTransaction();
    }
    private void closeSessionAndTransaction(){
        this.transaction.commit();
        this.session.close();
    }

    private void openSession(){
       this.session = sessionFactory.openSession();
    }
    private void closeSession(){
        this.session.close();
    }
}
