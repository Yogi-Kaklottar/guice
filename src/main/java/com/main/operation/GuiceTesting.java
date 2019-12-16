package com.main.operation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.main.java.TextEditor;
import com.main.java.TextModul;

public class GuiceTesting {

	public static void main(String[] args) {
		Injector injector=Guice.createInjector(new TextModul());
		TextEditor texteditor=injector.getInstance(TextEditor.class);
		texteditor.spellChecking();
		
		
	}

}
