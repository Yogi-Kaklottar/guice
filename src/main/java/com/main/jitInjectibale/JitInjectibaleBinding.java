package com.main.jitInjectibale;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class JitInjectibaleBinding {
		public static void main(String[] args)
		{
			Injector injector=Guice.createInjector(new StudentModule());
			TextEditor textEditor=injector.getInstance(TextEditor.class);
			textEditor.printName();
			
		}
}
//@ImplementedBy(TextEditor.class)
interface data {
	void display();
}

class Student implements data {

	@Inject @Named("name")
	String sname;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void display() {
			System.out.println("name:"+sname);
	}

}
class TextEditor{
	private Student s;
	
    @Inject
	public TextEditor(Student s) {
		super();
		this.s = s;
	}
    public void printName()
    {
    	s.display();
    }
	
}
class StudentModule extends AbstractModule{
		@Override
		protected void configure() {
			// TODO Auto-generated method stub
			super.configure();
			//bind(data.class).to(Student.class);
			bind(String.class).annotatedWith(Names.named("name")).toInstance("patel rajesh");;
		}
}