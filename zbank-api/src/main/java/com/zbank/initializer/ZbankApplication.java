package com.zbank.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.zbank.controller"})
@SpringBootApplication
public class ZbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZbankApplication.class, args);
	}
}
