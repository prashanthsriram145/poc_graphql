package com.prashanth.poc.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocGraphqlApplication.class, args);
	}

}
