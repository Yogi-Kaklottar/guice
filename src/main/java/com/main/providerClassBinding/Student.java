package com.main.providerClassBinding;

import com.google.inject.Inject;

public class Student implements Data {

	private int no;
	private String name;

	@Inject
	public Student(int no, String name) {
		
		this.no = no;
		this.name = name;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Student [no=" + no + ", name=" + name + "]");
	}

}