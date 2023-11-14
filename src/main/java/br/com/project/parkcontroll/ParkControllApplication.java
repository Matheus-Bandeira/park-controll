package br.com.project.parkcontroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ParkControllApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkControllApplication.class, args);
	}

}
