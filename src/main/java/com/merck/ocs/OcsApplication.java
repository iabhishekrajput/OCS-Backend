package com.merck.ocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcsApplication.class, args);
	}

}
