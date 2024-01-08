package org.example.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();

    Optional<T> getById(Integer id);

    T persist(T t);

    void delete(T t);

    void update(T t, String... args);

    Optional<T> getByName(String name);
}
