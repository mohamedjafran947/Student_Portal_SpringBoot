package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.example.demo.dao","com.example.demo.controller","com.example.demo.entity"})
public class FirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
		System.out.println("Hello world");
		
		
	}

}
