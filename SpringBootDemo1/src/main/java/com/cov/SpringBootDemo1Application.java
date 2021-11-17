package com.cov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cov.tester.Calculator;

@SpringBootApplication
public class SpringBootDemo1Application {

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(SpringBootDemo1Application.class, args);
		Calculator calc = ctxt.getBean(Calculator.class);
		int result = calc.add(10, 15);
		System.out.println("sum: " + result);
	}

}
