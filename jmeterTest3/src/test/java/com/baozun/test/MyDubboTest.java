/*
 * DubboTest.java Created On 2017年6月21日
 * Copyright(c) 2017 Mazan Inc.
 * ALL Rights Reserved.
 */
package com.baozun.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cl.user.servicei.UserService;

/**
 * DubboTest
 *
 * @time: 上午9:52:17
 * @author mazan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext-*.xml")
public class MyDubboTest {
	
	public static ClassPathXmlApplicationContext context;
	
	private UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (null == context) {
			context = new ClassPathXmlApplicationContext(new String[] { "spring/*.xml" });
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		context.start();
		userService = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
		context.destroy();
	}

	@Test
	public void testDubbo() {
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println(userService.sayHello());
	}

}

