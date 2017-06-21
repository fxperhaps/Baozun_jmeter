/*
 * HelloTest.java Created On 2017年6月21日
 * Copyright(c) 2017 Mazan Inc.
 * ALL Rights Reserved.
 */
package com.baozun.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * HelloTest
 *
 * @time: 上午9:38:18
 * @author mazan
 */
public class HelloTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testSayHello() {
		System.out.println("-----------testSayHello------------");
		Hello hello = new Hello();
		String result = hello.sayHello();
		System.out.println(result);
	}

	@Test
	public void testSayHelloToPerson() {
		System.out.println("-----------testSayHelloToPerson------------");
		Hello hello = new Hello();
		String name = "baozun";
		String result = hello.sayHelloToPerson(name);
		System.out.println(result);
	}

	@Test
	public void testSum() {
		System.out.println("-----------testSum------------");
		Hello hello = new Hello();
		int a = 100;
		int b = 200;
		int result = hello.sum(a, b);
		System.out.println(result);
		Assert.assertTrue(result == 300);
	}

}

