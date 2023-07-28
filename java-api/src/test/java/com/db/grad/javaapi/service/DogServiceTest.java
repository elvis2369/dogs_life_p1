package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogServiceTest {

    @Autowired
    DogsRepository itsDogRepo;
    @Autowired
    DogService cut;
    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){
        cut = new DogService(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);
    }
}
