package com.example.lighthouseSpringDemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceDemoTest {

	private ServiceDemo serviceDemo;
	
	@BeforeEach
	public void init() {
		serviceDemo = new ServiceDemo();
	}
	
	@Test
	public void isPalindrome_true() {
		
		int testData = 121;
		
		assertTrue(serviceDemo.isPalindrome(testData));
		
	}

	@Test
	public void isPalindrome_false() {
		ServiceDemo serviceDemo = new ServiceDemo();
		int testData = 1212;
		//boolean result = serviceDemo.isPalindrome(testData);
		//assertEquals(false, result);
		assertFalse(serviceDemo.isPalindrome(testData));
	}
	
//	@Test
//	public void isPalindrome_negative() {
//		ServiceDemo serviceDemo = new ServiceDemo();
//		int testData = -121;
//		boolean result = serviceDemo.isPalindrome(testData);
//		assertEquals(true, result);
//	}

}
