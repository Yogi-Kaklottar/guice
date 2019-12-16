package com.main.java;

public class TextEditor {	
	
	private SpellCheckImplement spellingCheck;
	@javax.inject.Inject
	public TextEditor(SpellCheckImplement spellingCheck) {
		super();
		this.spellingCheck = spellingCheck;
	}
	
	public void  spellChecking()
	{
		spellingCheck.spellChecking();
	}
	
}
