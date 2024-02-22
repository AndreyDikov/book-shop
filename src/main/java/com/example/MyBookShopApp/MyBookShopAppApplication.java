package com.example.MyBookShopApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MyBookShopAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBookShopAppApplication.class, args);
	}

}
