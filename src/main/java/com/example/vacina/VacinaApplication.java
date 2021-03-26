package com.example.vacina;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VacinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacinaApplication.class, args);
	}


	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
		}
}
