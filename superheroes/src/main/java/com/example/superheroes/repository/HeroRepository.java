package com.example.superheroes.repository;
import com.example.superheroes.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    List<Hero> findTop3ByOrderByNameDesc();

    @Query(nativeQuery = true, value = "select * from heroes where name like :letter")
    List<Hero> findHeroesNameStartingWithLetter(String letter);

}
