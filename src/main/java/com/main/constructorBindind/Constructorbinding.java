package com.main.constructorBindind;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Constructorbinding {
	
		public static void main(String[] args)
		{
			Injector injector=Guice.createInjector(new StudentModule());
			StudentEditor studentEditor=injector.getInstance(StudentEditor.class);
			studentEditor.PrintStudent();
			
		}
}
