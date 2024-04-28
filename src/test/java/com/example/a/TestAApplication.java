package com.example.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAApplication {

	public static void main(String[] args) {
		SpringApplication.from(AApplication::main).with(TestAApplication.class).run(args);
	}

}
