package com.andy.autocheckin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoCheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCheckinApplication.class, args);
	}

}
