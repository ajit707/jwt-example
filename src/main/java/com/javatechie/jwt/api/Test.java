package com.javatechie.jwt.api;

public class Test {

	public static void main(String[] args) {

		Object obj1 = new Object();

		Object[] obj2 = new Object[10];

		obj2[0] = obj1;

		System.out.println(obj1.hashCode());
		System.out.println(obj2[0].hashCode());
	}

}
