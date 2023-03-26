package com.kuroneko23.bookmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BookmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarketApplication.class, args);
	}

}
