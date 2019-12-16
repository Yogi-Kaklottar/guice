package com.main.nameAnnotation;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
public class NameModule {
	public static void main(String[] args) {
		
		Injector injector=Guice.createInjector(new TextEditorModule());
		WindowTextEditor wte=injector.getInstance(WindowTextEditor.class);
		wte.makeCheck();
		

	}

}

class TextEditorModule extends AbstractModule{
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		super.configure();
		bind(SpellCkeckInterface.class).annotatedWith(Names.named("callspellcheckinterface")).to(WindowDocCheckSpell.class);
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
		//super.CheckSpelling();
		System.out.println("spelling to be correct on WindowsCheckSpell  using  @named Binding named method.");
	}
}

class WindowTextEditor {
	private SpellCkeckInterface sci;

	@Inject
	public WindowTextEditor(@Named("callspellcheckinterface")SpellCkeckInterface sci) {
		this.sci = sci;
	}
    
	public void makeCheck() {
		sci.CheckSpelling();
	}

}