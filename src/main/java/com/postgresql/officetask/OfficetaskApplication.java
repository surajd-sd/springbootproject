package com.postgresql.officetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= "com.postgresql")
public class OfficetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficetaskApplication.class, args);
	}

}
