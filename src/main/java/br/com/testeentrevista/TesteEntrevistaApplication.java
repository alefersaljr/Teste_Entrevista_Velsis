package br.com.testeentrevista;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@Log4j2
@SpringBootApplication
public class TesteEntrevistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteEntrevistaApplication.class, args);
		log.info("API iniciada com sucesso as {}", LocalDateTime.now());
	}

}
