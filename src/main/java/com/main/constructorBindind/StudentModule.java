package com.main.constructorBindind;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class StudentModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
		try {
			bind(Data.class).toConstructor(Student.class.getConstructor(String.class));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace().toString());
		}
		bind(String.class).annotatedWith(Names.named("studentname")).toInstance("RajeshPatel");
		
	}
}
