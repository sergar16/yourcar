package org.serhiihokhkalenko.yourcar.database;


import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CarRepository<T, ID extends Serializable>
        extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

}
