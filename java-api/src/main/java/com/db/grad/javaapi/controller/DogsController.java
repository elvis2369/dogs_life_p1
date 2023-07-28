package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogsController {

    @Autowired
    DogService dogService;

    @GetMapping("/status")
    public String getStatus(){
        return "ok";
    }

    @GetMapping("/dog")
    public List<Dog> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/dogCount")
    public int getCountDogs(){

        return dogService.getAllDogs().size();
    }

    @GetMapping("/dog/{dogName}")
    public List<Dog> searchDog(@PathVariable String dogName){

        return dogService.searchByName(dogName);
    }

    @GetMapping("/dogId/{dogId}")
    public Dog searchDogById(@PathVariable long dogId){

        return dogService.searchById(dogId);
    }

}
