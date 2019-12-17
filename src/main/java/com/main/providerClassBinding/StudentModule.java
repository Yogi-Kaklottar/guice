package com.main.providerClassBinding;

import com.google.inject.AbstractModule;

public class StudentModule extends AbstractModule {
	@Override
	protected void configure() {
		// TODO Auto-generated 	super.configure();
		bind(Data.class).toProvider(StudentProvider.class);
	}
}
