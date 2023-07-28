package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogsRepository itsDogsRepo;
    public DogService(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public Dog addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs(){
        return itsDogsRepo.count();
    }

    public List<Dog> getAllDogs() {
        return itsDogsRepo.findAll();
    }

    public List<Dog> searchByName(String dogName) {

        return itsDogsRepo.findByName(dogName);
    }

    public Dog searchById(long dogId) {
        return itsDogsRepo.findById(dogId);
    }
}
