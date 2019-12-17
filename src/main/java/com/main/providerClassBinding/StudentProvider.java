package com.main.providerClassBinding;

import com.google.inject.Provider;

public class StudentProvider implements Provider<Data> {

	@Override
	public Data get() {
	
		return new Student(1, "raviraj");
	}

}