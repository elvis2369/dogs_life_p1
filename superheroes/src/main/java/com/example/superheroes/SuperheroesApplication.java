package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication {

	//@Autowired
	//Calculator calc;

	//@Autowired
	//HeroRepository heroRepository;

	@Autowired
	HeroService heroService;


	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {

		//Calculator calculator = new Calculator();
		//int result = calculator.addition(3,4);
		//System.out.println("Hello World\n"+"Calculator result = "+result);


		//List<Hero> heroes = heroRepository.findAll();
		//for (Hero hero: heroes){
			//System.out.println(hero);
	//}
		//List<Hero> heroes = heroService.getHeroesStartingWithLetter("C");
		//for (Hero hero : heroes){
		//	System.out.println(hero);
		//}

}
//}
