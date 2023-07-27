package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DogsRepositoryStubTest {
    DogsRepositoryStub dogsList = new DogsRepositoryStub();
    @BeforeEach
    void setUp() {

        Dog testDog1 = new Dog();
        Dog testDog2 = new Dog();
        Dog testDog3 = new Dog();

        testDog1.setName("Bruno");
        testDog2.setName("Robert");
        testDog3.setName("Shivam");

        testDog1.setId(1);
        testDog2.setId(2);
        testDog3.setId(3);

        dogsList.save(testDog1);
        dogsList.save(testDog2);
        dogsList.save(testDog3);
    }

    @Test
    @DisplayName("Test getDogByName")
    void getDogByName(){

        Dog expectedDog = new Dog();
        expectedDog.setName("Bruno");
        expectedDog.setId(1);

        // act
        Dog actualDog = dogsList.getDogByName("Bruno");

        assertEquals(expectedDog.getName(), actualDog.getName());
        assertEquals(expectedDog.getId(), actualDog.getId());
    }

    @Test
    @DisplayName("Test getDogByID")
    void getDogByID(){
        Dog expectedDog = new Dog();
        expectedDog.setName("Bruno");
        expectedDog.setId(1);

        Dog actualDog = dogsList.getDogByID(1);
        assertEquals(expectedDog.getId(), actualDog.getId());
    }
    @Test
    void add_dog() {
        // arrange
        long expectedIndex = 1;
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");

        // act
        long actualIndex = cut.save(theDog);

        // assert
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void get_first_dog_by_Id() {
        // arrange
        Dog expectedDog = new Dog();
        expectedDog.setId(1);
        expectedDog.setName("Bruno");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);

        // act
        Dog actualDog = cut.findById(1);

        // assert
        assertEquals(expectedDog.getName(), actualDog.getName());
        assertEquals(expectedDog.getId(), actualDog.getId());
    }

    @Test
    void get_second_dog_by_Id() {
        // arrange
        Dog expectedDog = new Dog();
        expectedDog.setId(2);
        expectedDog.setName("Penny");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);

        // act
        Dog actualDog = cut.findById(2);

        // assert
        assertEquals(expectedDog.getName(), actualDog.getName());
        assertEquals(expectedDog.getId(), actualDog.getId());
    }

    @Test
    void get_dog_by_name() {
        // arrange
        Dog expectedDog = new Dog();
        expectedDog.setId(2);
        expectedDog.setName("Penny");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);

        // act
        List<Dog> actualDog = cut.findByName(expectedDog);

        // assert
        assertEquals(1, actualDog.size());
        Dog retrievedDog = actualDog.get(0);
        assertEquals(expectedDog.getName(), retrievedDog.getName());
        assertEquals(expectedDog.getId(), retrievedDog.getId());
    }

    @Test
    void update_dog_details() {
        // arrange
        Dog dogToUpdate = new Dog();
        dogToUpdate.setId(1);
        dogToUpdate.setName("Frank");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);

        // act
        cut.save(dogToUpdate);
        Dog actualDog = cut.findById(1);

        // assert
        assertEquals(dogToUpdate.getName(), actualDog.getName());
        assertEquals(dogToUpdate.getId(), actualDog.getId());
    }

    @Test
    void delete_dog() {
        // arrange
        Dog dogToRemove = new Dog();
        dogToRemove.setId(1);
        dogToRemove.setName("Frank");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);

        // act
        cut.delete(dogToRemove);
        Dog actualDog = cut.findById(1);

        // assert
        assertNull(actualDog);
    }

    @Test
    void count_dogs_in_collection() {
        // arrange
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);
        long expectedResult = 2;

        // act
        long actualResult = cut.count();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void count_dogs_in_collection_after_change() {
        // arrange
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);
        Dog dogToUpdate = new Dog();
        dogToUpdate.setId(1);
        dogToUpdate.setName("Frank");

        long expectedResult = 2;

        // act
        long actualResult = cut.count();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void remove_all_dogs_in_collection() {
        // arrange
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save(theDog);
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save(theDog);
        long expectedResult = 0;

        // act
        cut.deleteAll();
        long actualResult = cut.count();

        // assert
        assertEquals(expectedResult, actualResult);
    }


}
