package com;



public class Greeter {

	public String SayHello(){
		System.out.println("A hello from normal class");
		return "hi";
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.SayHello();
	}
	
}