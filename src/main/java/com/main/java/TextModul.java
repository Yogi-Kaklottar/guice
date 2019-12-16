package com.main.java;

import com.google.inject.AbstractModule;

public class TextModul extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(SpellCheck.class).to(SpellCheckImplement.class);
		bind(SpellCheckImplement.class).to(WordClass.class);
	}
}
