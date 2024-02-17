package com.promineotech;

import java.util.Random;

public class TestDemo {
	

	
	int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}

	}

	/*
	 * Simple method to concact two strings; Tests will focus on ensuring the
	 * strings are concactanated correctly
	 */
	String concactStrings(String a, String b) {
		return a + " " + b;
	}
	

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	int randomNumberSquared() {
		int randomSquared = (int) Math.pow(getRandomInt(), 2);
		return randomSquared;
}
	
	}