package com.baozun.test;

public class Hello {
	/**
	 * 被测接口1
	 * @return
	 */
	public String sayHello() {
		return "Hello";
	}
	
	/**
	 * 被测接口2
	 * @param s
	 * @return
	 */
	public String sayHelloToPerson(String s) {
		if (s == null || s.equals(""))
			s = "nobody";
		return (new StringBuilder()).append("Hello ").append(s).toString();
	}
	
	/**
	 * 被测接口3
	 * @param a
	 * @param b
	 * @return
	 */
	public int sum(int a, int b) {
		return a + b;
	}
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}