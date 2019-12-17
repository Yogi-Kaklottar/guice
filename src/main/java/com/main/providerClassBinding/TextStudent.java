package com.main.providerClassBinding;

import com.google.inject.Inject;

public class TextStudent {
	private StudentProvider s;

	@Inject
	public TextStudent(StudentProvider s) {
		
		this.s = s;
	}

	public void printStudent() {
		s.get().display();
	}
}
