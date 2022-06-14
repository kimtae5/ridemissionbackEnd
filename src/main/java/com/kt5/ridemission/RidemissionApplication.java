package com.kt5.ridemission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RidemissionApplication {
	public static void main(String[] args) { 
		SpringApplication.run(RidemissionApplication.class, args);
	}

}
