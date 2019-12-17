package com.main.providerClassBinding;


import com.google.inject.Guice;
import com.google.inject.Injector;


public class ProviderClassBinding {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new StudentModule());
		TextStudent textStudent = injector.getInstance(TextStudent.class);
		textStudent.printStudent();
	}
}



