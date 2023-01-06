package com.study.GreenPlace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GreenPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenPlaceApplication.class, args);
	}

}
