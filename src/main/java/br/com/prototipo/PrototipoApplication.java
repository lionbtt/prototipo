package br.com.prototipo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PrototipoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototipoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
}
