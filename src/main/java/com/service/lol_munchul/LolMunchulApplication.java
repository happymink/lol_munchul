package com.service.lol_munchul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LolMunchulApplication {

	public static void main(String[] args) {
		SpringApplication.run(LolMunchulApplication.class, args);
	}

}
