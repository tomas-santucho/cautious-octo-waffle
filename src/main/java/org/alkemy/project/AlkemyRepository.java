package org.alkemy.project;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AlkemyRepository<T> {

    T save(T account);

    void deleteById(Long id);

    Optional<T> findById(Long id);

    List<T> findAll();

    void clear();

    boolean exists(T value);

    Optional<T> findAny(Predicate<T> predicate);

}
