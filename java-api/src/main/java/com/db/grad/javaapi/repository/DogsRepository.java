package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogsRepository extends JpaRepository<Dog, Integer> {
    Dog save(Dog theDog );
    Dog  findById( long id );
    List<Dog> findByName(String theDog );
    void delete( Dog theDog );
    long count();
    boolean existsById( long id );

    // Additional admin functionality
    void    deleteAll();
}
