package com.example.superheroes.repository;
import com.example.superheroes.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {



}
