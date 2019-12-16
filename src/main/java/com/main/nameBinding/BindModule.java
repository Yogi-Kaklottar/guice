package com.main.nameBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Inject;
import com.google.inject.BindingAnnotation;
import com.google.inject.AbstractModule;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;

@BindingAnnotation
@Target({ PARAMETER, FIELD, METHOD })
@Retention(RUNTIME)
@interface WinWord {

}

public class BindModule {
			public static void main(String[] args)
			{
				Injector injector=Guice.createInjector(new TextEditorModule());
				WindowTextEditor windowTextEditor=injector.getInstance(WindowTextEditor.class);
				windowTextEditor.makeCheck();
			}
}
class TextEditorModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
		
		 bind(SpellCkeckInterface.class).annotatedWith(WinWord.class).to(WindowDocCheckSpell.class);
	}

}
//spell check interface
interface SpellCkeckInterface {

	public void CheckSpelling();
}

//spell check implement class
class SpellCheckClass implements SpellCkeckInterface {

	@Override
	public void CheckSpelling() {

		System.out.println("Spelling to be correct");

	}

}

//spellcheckclass extends
class WindowDocCheckSpell extends SpellCheckClass {
	@Override
	public void CheckSpelling() {
		// TODO Auto-generated method stub
		super.CheckSpelling();
		System.out.println("spelling to be correct on WindowsCheckSpell.");
	}
}
class WindowTextEditor {
	private SpellCkeckInterface sci;

	@Inject
	public WindowTextEditor(@WinWord SpellCkeckInterface sci) {
		this.sci = sci;
	}

	public void makeCheck() {
		sci.CheckSpelling();
	}

}

