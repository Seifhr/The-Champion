package com.example.TheChampion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories({"com.example.TheChampion.Match", "com.example.TheChampion.Player","com.example.TheChampion.League"})
public class TheChampionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheChampionApplication.class, args);
	}

}