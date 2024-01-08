package org.example.DAO;

import org.example.entity.Author;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements DAO<Author> {

    private  final SessionFactory sessionFactory;
    private Session session;

    private Transaction transaction;

    public AuthorDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


    @Override
    public List<Author> getAll() {
        openSession();
        var authors = this.session.createQuery("SELECT a FROM AUTHOR a",Author.class).getResultList();
        closeSession();
        return  authors;
    }

    @Override
    public Optional<Author> getById(final Integer id) {
        openSession();
        var optionalAuthor = Optional.ofNullable(session.get(Author.class,id));
        closeSession();
        return optionalAuthor;
    }

    @Override
    public Author persist(Author author) {
        openSessionAndTransaction();
        var enhancedAuthor = session.merge(author);
        closeSession();
        return enhancedAuthor;
    }

    @Override
    public void delete(Author author) {
    openSessionAndTransaction();
    session.remove(author);
    closeSessionAndTransaction();
    }

    @Override
    public void update(Author author, String... args) {

    }
    private void openSessionAndTransaction(){
        this.session = sessionFactory.openSession();
        this.transaction = session.beginTransaction();
    }
    private void closeSessionAndTransaction(){
        this.transaction.commit();
        this.session.close();
    }

    @Override
    public Optional<Author> getByName(String name) {
        openSession();
        String query = "SELECT Danut d WHERE d.authorName = :name" ;
        Query<Author> authorQuery = session.createQuery(query,Author.class);
        authorQuery.setParameter("name",name);
       Optional<Author> singleResult = Optional.ofNullable(authorQuery.getSingleResultOrNull());
       closeSession();
       return singleResult;
    }

    private void openSession(){
        this.session = sessionFactory.openSession();
    }
    private void closeSession(){
        this.session.close();
    }
}
