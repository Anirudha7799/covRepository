package com.cov.tester;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public int add(int x, int y) {
		int z = x + y;
		return z;
	}
}
