package com.main.providerClassBinding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class ProviderClassBinding {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new StudentModule());
		TextStudent textStudent = injector.getInstance(TextStudent.class);
		textStudent.printStudent();
	}
}

interface data {
	void display();
}

class Student implements data {

	private int no;
	private String name;

	@Inject
	public Student(int no, String name) {
	
		this.no = no;
		this.name = name;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Student [no=" + no + ", name=" + name + "]");
	}

}

class TextStudent {
	
	private Student s;

	@Inject
	public TextStudent(Student s) {
		super();
		this.s = s;
	}

	public void printStudent() {
		s.display();
	}
}

class StudentProvider implements Provider<data> {

	@Override
	public data get() {
		data d ;
		Student s= new Student(1, "raviraj");
		d=s;
		return d;
	}

}

class StudentModule extends AbstractModule {
	@Override
	protected void configure() {
		// TODO Auto-generated 	super.configure();
		bind(data.class).toProvider(StudentProvider.class);
	}
}
