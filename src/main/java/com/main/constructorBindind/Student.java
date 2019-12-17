package com.main.constructorBindind;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Student implements Data {

	
	String s;
	
	public Student() {}
	@Inject
	public Student(@Named("studentname") String s) {
		//super();
	
		this.s = s;
	}

	@Override
	public void display() {

		System.out.println("Student name=" + s );
	}

}
